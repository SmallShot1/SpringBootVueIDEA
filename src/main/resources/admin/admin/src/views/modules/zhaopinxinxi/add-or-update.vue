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
        <el-form-item  v-if="type!='info'"  label="企业编号" prop="qiyebianhao">
          <el-input v-model="ruleForm.qiyebianhao" 
              placeholder="企业编号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.qiyebianhao" label="企业编号" prop="qiyebianhao">
              <el-input v-model="ruleForm.qiyebianhao" 
                placeholder="企业编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="企业名称" prop="qiyemingcheng">
          <el-input v-model="ruleForm.qiyemingcheng" 
              placeholder="企业名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.qiyemingcheng" label="企业名称" prop="qiyemingcheng">
              <el-input v-model="ruleForm.qiyemingcheng" 
                placeholder="企业名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="负责人" prop="fuzeren">
          <el-input v-model="ruleForm.fuzeren" 
              placeholder="负责人" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fuzeren" label="负责人" prop="fuzeren">
              <el-input v-model="ruleForm.fuzeren" 
                placeholder="负责人" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua" 
              placeholder="联系电话" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.lianxidianhua" label="联系电话" prop="lianxidianhua">
              <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="招聘岗位" prop="zhaopingangwei">
          <el-input v-model="ruleForm.zhaopingangwei" 
              placeholder="招聘岗位" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhaopingangwei" label="招聘岗位" prop="zhaopingangwei">
              <el-input v-model="ruleForm.zhaopingangwei" 
                placeholder="招聘岗位" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="招聘人数" prop="zhaopinrenshu">
          <el-input v-model="ruleForm.zhaopinrenshu" 
              placeholder="招聘人数" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhaopinrenshu" label="招聘人数" prop="zhaopinrenshu">
              <el-input v-model="ruleForm.zhaopinrenshu" 
                placeholder="招聘人数" readonly></el-input>
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
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="图片" prop="tupian">
          <file-upload
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="tupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tupian" label="图片" prop="tupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                                                                                          </el-row>
                                                                                                                                                      <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'" label="岗位要求" prop="gangweiyaoqiu">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="岗位要求"
                  v-model="ruleForm.gangweiyaoqiu">
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.gangweiyaoqiu" label="岗位要求" prop="gangweiyaoqiu">
                    <span>{{ruleForm.gangweiyaoqiu}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                                                                                                                                                                                                            <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="工作职责" prop="gongzuozhize">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.gongzuozhize" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.gongzuozhize" label="工作职责" prop="gongzuozhize">
                    <span v-html="ruleForm.gongzuozhize"></span>
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
                        qiyebianhao: '',
                                qiyemingcheng: '',
                                fuzeren: '',
                                lianxidianhua: '',
                                zhaopingangwei: '',
                                zhaopinrenshu: '',
                                gangweileibie: '',
                                xueli: '',
                                tupian: '',
                                gangweiyaoqiu: '',
                                gongzuozhize: '',
                                thumbsupnum: '',
                                crazilynum: '',
                      },
                                                                                                            gangweileibieOptions: [],
                                xueliOptions: [],
                                                                                          rules: {
                  qiyebianhao: [
                                                                                              ],
                  qiyemingcheng: [
                                                                                              ],
                  fuzeren: [
                                                                                              ],
                  lianxidianhua: [
                                                                                              ],
                  zhaopingangwei: [
                                                                                              ],
                  zhaopinrenshu: [
                                                                                              ],
                  gangweileibie: [
                                                                                              ],
                  xueli: [
                                                                                              ],
                  tupian: [
                                                                                              ],
                  gangweiyaoqiu: [
                                                                                              ],
                  gongzuozhize: [
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
                    if(o=='qiyebianhao'){
            this.ruleForm.qiyebianhao = obj[o];
            continue;
          }
                    if(o=='qiyemingcheng'){
            this.ruleForm.qiyemingcheng = obj[o];
            continue;
          }
                    if(o=='fuzeren'){
            this.ruleForm.fuzeren = obj[o];
            continue;
          }
                    if(o=='lianxidianhua'){
            this.ruleForm.lianxidianhua = obj[o];
            continue;
          }
                    if(o=='zhaopingangwei'){
            this.ruleForm.zhaopingangwei = obj[o];
            continue;
          }
                    if(o=='zhaopinrenshu'){
            this.ruleForm.zhaopinrenshu = obj[o];
            continue;
          }
                    if(o=='gangweileibie'){
            this.ruleForm.gangweileibie = obj[o];
            continue;
          }
                    if(o=='xueli'){
            this.ruleForm.xueli = obj[o];
            continue;
          }
                    if(o=='tupian'){
            this.ruleForm.tupian = obj[o];
            continue;
          }
                    if(o=='gangweiyaoqiu'){
            this.ruleForm.gangweiyaoqiu = obj[o];
            continue;
          }
                    if(o=='gongzuozhize'){
            this.ruleForm.gongzuozhize = obj[o];
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
                                    this.ruleForm.qiyebianhao = json.qiyebianhao
                                                this.ruleForm.qiyemingcheng = json.qiyemingcheng
                                                this.ruleForm.fuzeren = json.fuzeren
                                                this.ruleForm.lianxidianhua = json.lianxidianhua
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
         
                                                                                                                      },
                                                                                                                // 多级联动参数
                                                                                                                                              info(id) {
      this.$http({
        url: `zhaopinxinxi/info/${id}`,
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
            url: `zhaopinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.zhaopinxinxiCrossAddOrUpdateFlag = false;
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
      this.parent.zhaopinxinxiCrossAddOrUpdateFlag = false;
    },
                                                                                                                        tupianUploadChange(fileUrls) {
                this.ruleForm.tupian = fileUrls;
            },
                                                              }
};
</script>
<style lang="scss" scoped>
.editor{
  height: 500px;
}
</style>
