<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-form-item label="人脸图像" prop="value">
        <file-upload
          tip="点击上传"
          action="file/upload?type=1"
          :limit="1"
          :multiple="false"
          fileUrls=""
          @change="uploadChange"
        ></file-upload>
      </el-form-item>
      <el-form-item>
        <!-- <el-button type="primary" @click="onSubmit">提交</el-button> -->
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data(){
    return{
      ruleForm:{
        name:'faceFile',
        value:''
      },
      rules: {
        name: [{ required: true, message: "名称不能为空", trigger: "blur" }],
        value: [{ required: true, message: "人脸图像不能为空", trigger: "blur" }]
      }
    }
  },
  methods: {
    uploadChange(fileUrls) {
      this.ruleForm.value = fileUrls;
    },
    onSubmit () {
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: this.$api.configsave,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.ruleForm.value = ""
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
