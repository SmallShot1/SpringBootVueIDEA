<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="160px"
    >
      <el-form-item label="商品名称" prop="title">
        <el-input v-model="ruleForm.goodname" placeholder="商品名称" readonly></el-input>
      </el-form-item>
      <el-form-item label="商品图片" prop="picture">
        <img :src="ruleForm.picture" style="width:100px;">
      </el-form-item>
      <el-form-item label="购买数量" prop="buynumber">
        <el-input v-model="ruleForm.buynumber" placeholder="购买数量" readonly></el-input>
      </el-form-item>
      <el-form-item label="价格/积分" prop="price">
        <el-input v-model="ruleForm.price" placeholder="价格/积分" readonly></el-input>
      </el-form-item>
      <el-form-item label="总价格/总积分" prop="total">
        <el-input v-model="ruleForm.total" placeholder="总价格/总积分" readonly></el-input>
      </el-form-item>
      <el-form-item label="折扣总价格" prop="discounttotal">
        <el-input v-model="ruleForm.discounttotal" placeholder="折扣总价格" readonly></el-input>
      </el-form-item>
      <el-form-item label="支付类型" prop="type">
        <el-tag v-if="ruleForm.type=='1'" type="success">现金</el-tag>
        <el-tag v-if="ruleForm.type=='2'" type="info">积分</el-tag>
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input v-model="ruleForm.address" placeholder="地址" readonly></el-input>
      </el-form-item>
      <el-form-item v-if="status == '已支付'" label="状态" prop="status">
        <el-select v-model="ruleForm.status" placeholder="请选择类别名称">
          <el-option label="已支付" value="已支付"></el-option>
          <el-option label="已完成" value="已完成"></el-option>
          <el-option label="已取消" value="已取消"></el-option>
          <el-option label="已退款" value="已退款"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button v-if="ruleForm.status == '已支付'" type="primary" @click="onSubmit">提交</el-button>
        <el-button @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {},
      status: "",
      rules: {}
    };
  },
  props: ["parent"],
  methods: {
    // 初始化
    init(id) {
      this.$http({
        url: `${this.$api.orderinfo}${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
          this.status = this.ruleForm.status;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    // 提交
    onSubmit() {
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `${
              !this.ruleForm.id
                ? `${this.$api.ordersave}`
                : `${this.$api.orderupdate}`
            }`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = false;
                  this.parent.search();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 返回
    back() {
      this.parent.showFlag = false;
    }
  }
};
</script>
<style lang="scss" scoped>
.editor {
  height: 500px;
}
</style>
