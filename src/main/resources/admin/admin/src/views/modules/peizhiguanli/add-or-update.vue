<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-form-item label="名称" prop="name">
        <el-input v-model="ruleForm.name" placeholder="名称" clearable readonly></el-input>
      </el-form-item>
      <el-form-item label="值" prop="value">
        <file-upload
          v-if="ruleForm.name.indexOf('picture')>=0|ruleForm.name=='homepage'"
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.value?ruleForm.value:''"
          @change="valueUploadChange"
        ></file-upload>
        <el-input v-else v-model="ruleForm.value" placeholder="值" clearable></el-input>
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
        name: [{ required: true, message: "名称不能为空", trigger: "blur" }],
        value: [{ required: true, message: "值不能为空", trigger: "blur" }]
      }
    };
  },
  props: ["parent"],
  methods: {
    // 初始化
    init(row) {
      this.ruleForm = row;
    },
    // 提交
    onSubmit() {
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: this.$api.configupdate,
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
    },
    valueUploadChange(fileUrls) {
      this.ruleForm.value = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
.editor {
  height: 500px;
}
</style>
