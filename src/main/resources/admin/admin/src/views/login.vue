<template>
    <div>
        <img class="bg" src="@/assets/img/bg.jpg">
        <el-form :model="rulesForm" :rules="rules" ref="rulesForm" class="login-form">
            <h1 class="h1">校园招聘系统登录</h1>
            <el-form-item label="账号" prop="username">
                <el-input type="text" v-model="rulesForm.username"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="rulesForm.password"></el-input>
            </el-form-item>
            <el-form-item label="" prop="role">
                <el-radio v-for="item in menus" v-bind:key="item.roleName" v-model="rulesForm.role"
                          :label="item.roleName">{{item.roleName}}
                </el-radio>
            </el-form-item>
            <el-form-item label="">
                <a style="margin-right:10px" href="javascript:void(0)" @click="register('yonghu')">注册用户</a>
                <a style="margin-right:10px" href="javascript:void(0)" @click="register('qiyexinxi')">注册企业信息</a>
            </el-form-item>
            <el-button @click="login()" class="btn-login" type="primary">登录</el-button>
        </el-form>
    </div>
</template>
<script>
    import menu from '@/utils/menu'

    export default {
        data() {
            return {
                rulesForm: {
                    username: "",
                    password: "",
                    role: ""
                },
                menus: [],
                tableName: "",
                rules: {
                    username: [{required: true, message: "请输入账号", trigger: "blur"}],
                    password: [{required: true, message: "请输入密码", trigger: "blur"}],
                    role: [{required: true, message: "请选择角色", trigger: "blur"}]
                }
            };
        },
        mounted() {
            let menus = menu.list();
            this.menus = menus;
        },
        methods: {
            register(tableName) {
                this.$storage.set("loginTable", tableName);
                this.$router.push({path: '/register'})
            },
            // 登录
            login() {
                this.$refs["rulesForm"].validate(valid => {
                    let menus = this.menus;
                    for (let i = 0; i < menus.length; i++) {
                        if (menus[i].roleName == this.rulesForm.role) {
                            this.tableName = menus[i].tableName
                        }
                    }
                    if (valid) {
                        this.$http({
                            url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
                            method: "post"
                        }).then(({data}) => {
                            if (data && data.code === 0) {
                                this.$storage.set("Token", data.token);
                                this.$storage.set("role", this.rulesForm.role);
                                this.$storage.set("sessionTable", this.tableName);
                                this.$storage.set("adminName", this.rulesForm.username);
                                this.$router.replace({path: "/index/"});
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