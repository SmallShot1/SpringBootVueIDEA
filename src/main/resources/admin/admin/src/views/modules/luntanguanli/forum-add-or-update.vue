<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-form-item label="标题" prop="title">
        <el-input v-model="ruleForm.title" placeholder="标题" clearable></el-input>
      </el-form-item>
      <el-form-item label="是否开放" prop="isdone">
        <el-select v-model="ruleForm.isdone" placeholder="是否开放">
          <el-option  label="开放" value="开放"></el-option>
          <el-option  label="关闭" value="关闭"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="内容" prop="content">
        <editor :value="ruleForm.content" v-model="ruleForm.content" class="editor" action="file/upload"></editor>
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
      ruleForm: {
        title:'',
        content:''
      },
      rules: {
        title: [
          { required: true, message: "名称不能为空", trigger: "blur" }
        ],
        content: [
          { required: true, message: "内容不能为空", trigger: "blur" }
        ]
      }
    };
  },
  props: ["parent"],
  methods: {
    // 初始化
    init(id) {
      this.$http({
        url: `${this.$api.foruminfo}${id}`,
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
            url: `${!this.ruleForm.id ? `${this.$api.forumsave}` : `${this.$api.forumupdate}`}`,
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
