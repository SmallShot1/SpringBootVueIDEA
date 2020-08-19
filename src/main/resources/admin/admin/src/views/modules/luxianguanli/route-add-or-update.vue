<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-form-item label="路线名称" prop="title">
        <el-input v-model="ruleForm.title" placeholder="路线名称" clearable></el-input>
      </el-form-item>
      <el-form-item label="路线节点" prop="allnode">
        <el-input v-model="ruleForm.allnode" placeholder="路线节点" clearable></el-input>
        <el-alert
          style="margin-top:10px;width:400px;"
          title="多个路线节点用,隔开"
          type="success"
          :closable="false"
        ></el-alert>
      </el-form-item>
      <el-form-item label="当前节点" prop="curnode">
        <el-input v-model="ruleForm.curnode" placeholder="当前节点" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
        <el-button @click="back()">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {},
      rules: {
        title: [
          { required: true, message: "路线名称不能为空", trigger: "blur" }
        ],
        allnode: [
          { required: true, message: "路线节点不能为空", trigger: "blur" }
        ],
        curnode: [
          { required: true, message: "当前节点不能为空", trigger: "blur" }
        ]
      }
    };
  },
  props: ["parent"],
  methods: {
    // 初始化
    init(id) {
      this.$http({
        url: `${this.$api.routeinfo}${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
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
            url: `${!this.ruleForm.id ? `${this.$api.routesave}` : `${this.$api.routeupdate}`}`,
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
