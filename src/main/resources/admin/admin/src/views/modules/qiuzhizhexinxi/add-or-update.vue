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
        <el-form-item  v-if="type!='info'"  label="用户名" prop="yonghuming">
          <el-input v-model="ruleForm.yonghuming" 
              placeholder="用户名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yonghuming" label="用户名" prop="yonghuming">
              <el-input v-model="ruleForm.yonghuming" 
                placeholder="用户名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming" 
              placeholder="姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xingming" label="姓名" prop="xingming">
              <el-input v-model="ruleForm.xingming" 
                placeholder="姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="性别" prop="xingbie">
          <el-input v-model="ruleForm.xingbie" 
              placeholder="性别" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xingbie" label="性别" prop="xingbie">
              <el-input v-model="ruleForm.xingbie" 
                placeholder="性别" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="电话" prop="dianhua">
          <el-input v-model="ruleForm.dianhua" 
              placeholder="电话" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.dianhua" label="电话" prop="dianhua">
              <el-input v-model="ruleForm.dianhua" 
                placeholder="电话" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="照片" prop="zhaopian">
          <file-upload
          tip="点击上传照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.zhaopian?ruleForm.zhaopian:''"
          @change="zhaopianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhaopian" label="照片" prop="zhaopian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.zhaopian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="学历" prop="xueli">
          <el-select v-model="ruleForm.xueli" placeholder="请选择学历">
            <el-option
                v-for="(item,index) in xueliOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xueli" label="学历" prop="xueli">
              <el-input v-model="ruleForm.xueli" 
                placeholder="学历" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="岗位类别" prop="gangweileibie">
          <el-select v-model="ruleForm.gangweileibie" placeholder="请选择岗位类别">
            <el-option
                v-for="(item,index) in gangweileibieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.gangweileibie" label="岗位类别" prop="gangweileibie">
              <el-input v-model="ruleForm.gangweileibie" 
                placeholder="岗位类别" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="简历" prop="jianli">
          <file-upload
          tip="点击上传简历"
          action="file/upload"
          :limit="1"
          :multiple="true"
          :fileUrls="ruleForm.jianli?ruleForm.jianli:''"
          @change="jianliUploadChange"
          ></file-upload>
        </el-form-item>  
        <div v-else>
          <el-form-item v-if="ruleForm.jianli" label="简历" prop="jianli">
            <el-button type="text" size="small" @click="download(ruleForm.jianli)">下载</el-button>
          </el-form-item>
        </div>    
      </el-col>      
                                                                                          </el-row>
                                                                                                                                        <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'" label="工作经历" prop="gongzuojingli">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="工作经历"
                  v-model="ruleForm.gongzuojingli">
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.gongzuojingli" label="工作经历" prop="gongzuojingli">
                    <span>{{ruleForm.gongzuojingli}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                                                                                                                                                                                              <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="个人基本情况" prop="gerenjibenqingkuang">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.gerenjibenqingkuang" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.gerenjibenqingkuang" label="个人基本情况" prop="gerenjibenqingkuang">
                    <span v-html="ruleForm.gerenjibenqingkuang"></span>
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
                        yonghuming: '',
                                xingming: '',
                                xingbie: '',
                                dianhua: '',
                                zhaopian: '',
                                xueli: '',
                                gangweileibie: '',
                                jianli: '',
                                gongzuojingli: '',
                                gerenjibenqingkuang: '',
                                thumbsupnum: '',
                                crazilynum: '',
                      },
                                                                                              xueliOptions: [],
                                gangweileibieOptions: [],
                                                                                          rules: {
                  yonghuming: [
                                                                                              ],
                  xingming: [
                                                                                              ],
                  xingbie: [
                                                                                              ],
                  dianhua: [
                                                                                              ],
                  zhaopian: [
                                                                                              ],
                  xueli: [
                                                                                              ],
                  gangweileibie: [
                                                                                              ],
                  jianli: [
                                                                                              ],
                  gongzuojingli: [
                                                                                              ],
                  gerenjibenqingkuang: [
                                                                                              ],
                  thumbsupnum: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  crazilynum: [
                                        { validator: validateIntNumber, trigger: 'blur' },
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
                    if(o=='yonghuming'){
            this.ruleForm.yonghuming = obj[o];
            continue;
          }
                    if(o=='xingming'){
            this.ruleForm.xingming = obj[o];
            continue;
          }
                    if(o=='xingbie'){
            this.ruleForm.xingbie = obj[o];
            continue;
          }
                    if(o=='dianhua'){
            this.ruleForm.dianhua = obj[o];
            continue;
          }
                    if(o=='zhaopian'){
            this.ruleForm.zhaopian = obj[o];
            continue;
          }
                    if(o=='xueli'){
            this.ruleForm.xueli = obj[o];
            continue;
          }
                    if(o=='gangweileibie'){
            this.ruleForm.gangweileibie = obj[o];
            continue;
          }
                    if(o=='jianli'){
            this.ruleForm.jianli = obj[o];
            continue;
          }
                    if(o=='gongzuojingli'){
            this.ruleForm.gongzuojingli = obj[o];
            continue;
          }
                    if(o=='gerenjibenqingkuang'){
            this.ruleForm.gerenjibenqingkuang = obj[o];
            continue;
          }
                    if(o=='thumbsupnum'){
            this.ruleForm.thumbsupnum = obj[o];
            continue;
          }
                    if(o=='crazilynum'){
            this.ruleForm.crazilynum = obj[o];
            continue;
          }
                  }
                                                                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                    this.ruleForm.yonghuming = json.yonghuming
                                                this.ruleForm.xingming = json.xingming
                                                this.ruleForm.xingbie = json.xingbie
                                                this.ruleForm.dianhua = json.dianhua
                                                                                                                                                                                                              } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                    this.$http({
              url: `option/xuelixinxi/xueli`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.xueliOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
                                        this.$http({
              url: `option/gangweifenlei/gangweileibie`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.gangweileibieOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
                                                                                                                      },
                                                                                                        // 多级联动参数
                                                                                                                                    info(id) {
      this.$http({
        url: `qiuzhizhexinxi/info/${id}`,
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
            url: `qiuzhizhexinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.qiuzhizhexinxiCrossAddOrUpdateFlag = false;
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
      this.parent.qiuzhizhexinxiCrossAddOrUpdateFlag = false;
    },
                                                                        zhaopianUploadChange(fileUrls) {
                this.ruleForm.zhaopian = fileUrls;
            },
                                                        jianliUploadChange(fileUrls) {
                this.ruleForm.jianli = fileUrls;
            },
                                                              }
};
</script>
<style lang="scss" scoped>
.editor{
  height: 500px;
}
</style>
