<template>
    <div>
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                label-width="80px"
        >
            <el-col :span="12">
                <el-form-item v-if="flag=='yonghu'" label="用户名" prop="yonghuming">
                    <el-input v-model="ruleForm.yonghuming"
                              placeholder="用户名" clearable></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item v-if="flag=='yonghu'" label="姓名" prop="xingming">
                    <el-input v-model="ruleForm.xingming"
                              placeholder="姓名" clearable></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item v-if="flag=='yonghu'" label="密码" prop="mima">
                    <el-input v-model="ruleForm.mima"
                              placeholder="密码" clearable></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item v-if="flag=='yonghu'" label="性别" prop="xingbie">
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
                        <el-option
                                v-for="(item,index) in yonghuxingbieOptions"
                                v-bind:key="index"
                                :label="item"
                                :value="item">
                        </el-option>
                    </el-select>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item v-if="flag=='yonghu'" label="电话" prop="dianhua">
                    <el-input v-model="ruleForm.dianhua"
                              placeholder="电话" clearable></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item v-if="flag=='yonghu'" label="邮箱" prop="youxiang">
                    <el-input v-model="ruleForm.youxiang"
                              placeholder="邮箱" clearable></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item v-if="flag=='qiyexinxi'" label="企业编号" prop="qiyebianhao">
                    <el-input v-model="ruleForm.qiyebianhao"
                              placeholder="企业编号" clearable></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item v-if="flag=='qiyexinxi'" label="密码" prop="mima">
                    <el-input v-model="ruleForm.mima"
                              placeholder="密码" clearable></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item v-if="flag=='qiyexinxi'" label="企业名称" prop="qiyemingcheng">
                    <el-input v-model="ruleForm.qiyemingcheng"
                              placeholder="企业名称" clearable></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item v-if="flag=='qiyexinxi'" label="负责人" prop="fuzeren">
                    <el-input v-model="ruleForm.fuzeren"
                              placeholder="负责人" clearable></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item v-if="flag=='qiyexinxi'" label="联系电话" prop="lianxidianhua">
                    <el-input v-model="ruleForm.lianxidianhua"
                              placeholder="联系电话" clearable></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item v-if="flag=='qiyexinxi'" label="企业邮箱" prop="qiyeyouxiang">
                    <el-input v-model="ruleForm.qiyeyouxiang"
                              placeholder="企业邮箱" clearable></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item v-if="flag=='qiyexinxi'" label="企业介绍" prop="qiyejieshao">
                    <el-input v-model="ruleForm.qiyejieshao"
                              placeholder="企业介绍" clearable></el-input>
                </el-form-item>
            </el-col>
            <el-form-item v-if="flag=='users'" label="用户名" prop="username">
                <el-input v-model="ruleForm.username"
                          placeholder="用户名"></el-input>
            </el-form-item>
            <el-col :span="24">
                <el-form-item>
                    <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
                </el-form-item>
            </el-col>
        </el-form>
    </div>
</template>
<script>
    // 数字，邮件，手机，url，身份证校验
    import {isNumber, isIntNumer, isEmail, isMobile, isURL, checkIdCard} from "@/utils/validate";

    export default {
        data() {
            return {
                ruleForm: {},
                flag: '',
                usersFlag: false,
                yonghuxingbieOptions: [],
            };
        },
        mounted() {
            var table = this.$storage.get("sessionTable");
            this.flag = table;
            this.$http({
                url: `${this.$storage.get("sessionTable")}/session`,
                method: "get"
            }).then(({data}) => {
                if (data && data.code === 0) {
                    this.ruleForm = data.data;
                } else {
                    this.$message.error(data.msg);
                }
            });
            this.yonghuxingbieOptions = "男,女".split(',')
        },
        methods: {
            onUpdateHandler() {
                if ((!this.ruleForm.yonghuming) && 'yonghu' == this.flag) {
                    this.$message.error('用户名不能为空');
                    return
                }
                if ((!this.ruleForm.xingming) && 'yonghu' == this.flag) {
                    this.$message.error('姓名不能为空');
                    return
                }
                if ((!this.ruleForm.mima) && 'yonghu' == this.flag) {
                    this.$message.error('密码不能为空');
                    return
                }
                if ('yonghu' == this.flag && this.ruleForm.dianhua && (!isMobile(this.ruleForm.dianhua))) {
                    this.$message.error(`电话应输入电话格式`);
                    return
                }
                if ('qiyexinxi' == this.flag && this.ruleForm.lianxidianhua && (!isMobile(this.ruleForm.lianxidianhua))) {
                    this.$message.error(`联系电话应输入电话格式`);
                    return
                }
                if ('qiyexinxi' == this.flag && this.ruleForm.qiyeyouxiang && (!isEmail(this.ruleForm.qiyeyouxiang))) {
                    this.$message.error(`企业邮箱应输入邮箱格式`);
                    return
                }
                this.$http({
                    url: `${this.$storage.get("sessionTable")}/update`,
                    method: "post",
                    data: this.ruleForm
                }).then(({data}) => {
                    if (data && data.code === 0) {
                        this.$message({
                            message: "修改信息成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                            }
                        });
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            }
        }
    };
</script>
<style lang="scss" scoped>
</style>
