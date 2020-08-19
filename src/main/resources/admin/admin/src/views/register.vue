<template>
  <div>
    <img class="bg" src="@/assets/img/bg.jpg">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="login-form">
      <h1 class="h1">校园招聘系统注册</h1>
                              <el-form-item v-if="tableName=='yonghu'" label="用户名" prop="yonghuyonghuming">
        <el-input v-model="ruleForm.yonghuming" placeholder="用户名"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yonghu'" label="姓名" prop="yonghuxingming">
        <el-input v-model="ruleForm.xingming" placeholder="姓名"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yonghu'" label="密码" prop="yonghumima">
        <el-input v-model="ruleForm.mima" placeholder="密码"></el-input>
      </el-form-item>
                                          <el-form-item v-if="tableName=='yonghu'" label="电话" prop="yonghudianhua">
        <el-input v-model="ruleForm.dianhua" placeholder="电话"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yonghu'" label="邮箱" prop="yonghuyouxiang">
        <el-input v-model="ruleForm.youxiang" placeholder="邮箱"></el-input>
      </el-form-item>
                                                <el-form-item v-if="tableName=='qiyexinxi'" label="企业编号" prop="qiyexinxiqiyebianhao">
        <el-input v-model="ruleForm.qiyebianhao" placeholder="企业编号"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='qiyexinxi'" label="密码" prop="qiyexinximima">
        <el-input v-model="ruleForm.mima" placeholder="密码"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='qiyexinxi'" label="企业名称" prop="qiyexinxiqiyemingcheng">
        <el-input v-model="ruleForm.qiyemingcheng" placeholder="企业名称"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='qiyexinxi'" label="负责人" prop="qiyexinxifuzeren">
        <el-input v-model="ruleForm.fuzeren" placeholder="负责人"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='qiyexinxi'" label="联系电话" prop="qiyexinxilianxidianhua">
        <el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='qiyexinxi'" label="企业邮箱" prop="qiyexinxiqiyeyouxiang">
        <el-input v-model="ruleForm.qiyeyouxiang" placeholder="企业邮箱"></el-input>
      </el-form-item>
                                                                                                                                                                                    <el-button @click="login()" class="btn-login" type="primary">注册</el-button>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {
              },
      tableName:"",
      rules: {}
    };
  },
  mounted(){
    let table = this.$storage.get("loginTable");
    this.tableName = table;
  },
  methods: {
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 注册
    login() {
                              if((!this.ruleForm.yonghuming) && `yonghu` == this.tableName){
        this.$message.error(`用户名不能为空`);
        return
      }
                                                            if((!this.ruleForm.xingming) && `yonghu` == this.tableName){
        this.$message.error(`姓名不能为空`);
        return
      }
                                                            if((!this.ruleForm.mima) && `yonghu` == this.tableName){
        this.$message.error(`密码不能为空`);
        return
      }
                                                                                                                              if(`yonghu` == this.tableName && this.ruleForm.dianhua&&(!this.$validate.isMobile(this.ruleForm.dianhua))){
        this.$message.error(`电话应输入电话格式`);
        return
      }
                                                                                                                                                                                                                                                                                                                                    if(`qiyexinxi` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入电话格式`);
        return
      }
                                                                  if(`qiyexinxi` == this.tableName && this.ruleForm.qiyeyouxiang&&(!this.$validate.isEmail(this.ruleForm.qiyeyouxiang))){
        this.$message.error(`企业邮箱应输入邮件格式`);
        return
      }
                                                                                                                                                                                                                              this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `${this.tableName}/register`,
            method: "post",
            data:this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$router.replace({ path: "/login" });
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
