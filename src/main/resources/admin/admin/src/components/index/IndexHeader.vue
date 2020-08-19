<template>
  <el-header>
    <el-menu
      mode="horizontal"
    >
      <div class="fl title">{{this.$project.projectName}}</div>
      <div class="fr logout" style="display:flex;">
        <el-menu-item index="3">
          <div>{{this.$storage.get('role')}} {{this.$storage.get('adminName')}}</div>
        </el-menu-item>
        <el-menu-item @click="onLogout" index="2">
          <div>退出登录</div>
        </el-menu-item>
      </div>

    </el-menu>
    <el-dialog title="修改密码" :visible.sync="dialogVisible" width="40%" append-to-body>
      <el-form ref="ruleForm" :model="ruleForm" label-width="80px">
        <el-form-item label="原密码">
          <el-input v-model="ruleForm.password"></el-input>
        </el-form-item>
        <el-form-item label="新密码">
          <el-input v-model="ruleForm.newpassword"></el-input>
        </el-form-item>
        <el-form-item label="确认密码">
          <el-input v-model="ruleForm.repassword"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </el-header>
</template>

<script>
export default {
  data() {
    return {
      dialogVisible: false,
      ruleForm: {}
    };
  },
  mounted(){

  },
  methods: {
    onLogout() {
      this.$storage.remove("Token");
      this.$router.replace({ name: "login" });
    },
    // 修改密码
    onUpdateHandler() {
      this;
    }
  }
};
</script>


<style lang="scss" scoped>
.el-header .fr {
  float: right;
}
.el-header .fl {
  float: left;
}
.el-header {
  width: 100%;
  color: #333;
  text-align: center;
  line-height: 60px;
  padding: 0;
  z-index: 99;
}
.logo {
  width: 60px;
  height: 60px;
  margin-left: 70px;
}
.avator {
  width: 40px;
  height: 40px;
  background: #ffffff;
  border-radius: 50%;
}
.title {
  color: #ffffff;
  font-size: 20px;
  font-weight: bold;
  margin-left: 20px;
}
</style>
