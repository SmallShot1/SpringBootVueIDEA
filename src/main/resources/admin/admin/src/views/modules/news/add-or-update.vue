<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-row>
                  <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="标题" prop="title">
          <el-input v-model="ruleForm.title" 
              placeholder="标题" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.title" label="标题" prop="title">
              <el-input v-model="ruleForm.title" 
                placeholder="标题" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="图片" prop="picture">
          <file-upload
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.picture?ruleForm.picture:''"
          @change="pictureUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.picture" label="图片" prop="picture">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.picture.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                                    </el-row>
                                                                                                    <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="内容" prop="content">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.content" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.content" label="内容" prop="content">
                    <span v-html="ruleForm.content"></span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                    <el-form-item>
                <el-button v-if="type!='info'" type="primary" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
      id: '',
      type: '',
      ruleForm: {
                        title: '',
                                picture: '',
                                content: '',
                      },
                                                      rules: {
                  title: [
                            { required: true, message: '标题不能为空', trigger: 'blur' },
                                                                                              ],
                  picture: [
                            { required: true, message: '图片不能为空', trigger: 'blur' },
                                                                                              ],
                  content: [
                            { required: true, message: '内容不能为空', trigger: 'blur' },
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                          },
  methods: {
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
                    if(o=='title'){
            this.ruleForm.title = obj[o];
            continue;
          }
                    if(o=='picture'){
            this.ruleForm.picture = obj[o];
            continue;
          }
                    if(o=='content'){
            this.ruleForm.content = obj[o];
            continue;
          }
                  }
                                                              }
                                                                                    },
                                // 多级联动参数
                                          info(id) {
      this.$http({
        url: `news/info/${id}`,
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
            url: `news/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.newsCrossAddOrUpdateFlag = false;
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
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.newsCrossAddOrUpdateFlag = false;
    },
                                    pictureUploadChange(fileUrls) {
                this.ruleForm.picture = fileUrls;
            },
                          }
};
</script>
<style lang="scss" scoped>
.editor{
  height: 500px;
}
</style>
