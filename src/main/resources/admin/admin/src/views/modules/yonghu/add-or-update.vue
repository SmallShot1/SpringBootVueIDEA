<template>
    <div>
        <el-form
            class="detail-form-content"
            ref="ruleForm"
            :model="ruleForm"
            :rules="rules"
            label-width="80px">

            <el-row>
                <el-col :span="12">
                    <el-form-item v-if="type!='info'" label="用户名" prop="yonghuming">
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
                    <el-form-item v-if="type!='info'" label="姓名" prop="xingming">
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
                    <el-form-item v-if="type!='info'" label="密码" prop="mima">
                        <el-input v-model="ruleForm.mima"
                                  placeholder="密码" clearable></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.mima" label="密码" prop="mima">
                            <el-input v-model="ruleForm.mima"
                                      placeholder="密码" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item v-if="type!='info'" label="性别" prop="xingbie">
                        <el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
                            <el-option
                                    v-for="(item,index) in xingbieOptions"
                                    v-bind:key="index"
                                    :label="item"
                                    :value="item">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.xingbie" label="性别" prop="xingbie">
                            <el-input v-model="ruleForm.xingbie"
                                      placeholder="性别" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item v-if="type!='info'" label="电话" prop="dianhua">
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
                <el-col :span="12">
                    <el-form-item v-if="type!='info'" label="邮箱" prop="youxiang">
                        <el-input v-model="ruleForm.youxiang"
                                  placeholder="邮箱" clearable></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.youxiang" label="邮箱" prop="youxiang">
                            <el-input v-model="ruleForm.youxiang"
                                      placeholder="邮箱" readonly></el-input>
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
    import {isNumber, isIntNumer, isEmail, isMobile, isURL, checkIdCard} from "@/utils/validate";

    export default {
        data() {
            var validateIdCard = (rule, value, callback) => {
                if (!value) {
                    callback();
                } else if (!checkIdCard(value)) {
                    callback(new Error("请输入正确的身份证号码"));
                } else {
                    callback();
                }
            };
            var validateUrl = (rule, value, callback) => {
                if (!value) {
                    callback();
                } else if (!isURL(value)) {
                    callback(new Error("请输入正确的URL地址"));
                } else {
                    callback();
                }
            };
            var validatePhone = (rule, value, callback) => {
                if (!value) {
                    callback();
                } else if (!isMobile(value)) {
                    callback(new Error("请输入正确的电话号码"));
                } else {
                    callback();
                }
            };
            var validateEmail = (rule, value, callback) => {
                if (!value) {
                    callback();
                } else if (!isEmail(value)) {
                    callback(new Error("请输入正确的邮箱地址"));
                } else {
                    callback();
                }
            };
            var validateNumber = (rule, value, callback) => {
                if (!value) {
                    callback();
                } else if (!isNumber(value)) {
                    callback(new Error("请输入数字"));
                } else {
                    callback();
                }
            };
            var validateIntNumber = (rule, value, callback) => {
                if (!value) {
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
                    mima: '',
                    xingbie: '',
                    dianhua: '',
                    youxiang: '',
                },
                xingbieOptions: [],
                rules: {
                    yonghuming: [
                        {required: true, message: '用户名不能为空', trigger: 'blur'},
                    ],
                    xingming: [
                        {required: true, message: '姓名不能为空', trigger: 'blur'},
                    ],
                    mima: [
                        {required: true, message: '密码不能为空', trigger: 'blur'},
                    ],
                    xingbie: [],
                    dianhua: [
                        {validator: validatePhone, trigger: 'blur'},
                    ],
                    youxiang: [],
                }
            };
        },
        props: ["parent"],
        computed: {},
        methods: {
            // 下载
            download(file) {
                window.open(`${file}`)
            },
            // 初始化
            init(id, type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if (this.type == 'info' || this.type == 'else') {
                    this.info(id);
                } else if (this.type == 'cross') {
                    var obj = this.$storage.getObj('crossObj');
                    for (var o in obj) {
                        if (o == 'yonghuming') {
                            this.ruleForm.yonghuming = obj[o];
                            continue;
                        }
                        if (o == 'xingming') {
                            this.ruleForm.xingming = obj[o];
                            continue;
                        }
                        if (o == 'mima') {
                            this.ruleForm.mima = obj[o];
                            continue;
                        }
                        if (o == 'xingbie') {
                            this.ruleForm.xingbie = obj[o];
                            continue;
                        }
                        if (o == 'dianhua') {
                            this.ruleForm.dianhua = obj[o];
                            continue;
                        }
                        if (o == 'youxiang') {
                            this.ruleForm.youxiang = obj[o];
                            continue;
                        }
                    }
                }
                this.xingbieOptions = "男,女".split(',')
            },
            // 多级联动参数
            info(id) {
                this.$http({
                    url: `yonghu/info/${id}`,
                    method: "get"
                }).then(({data}) => {
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
                            url: `yonghu/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({data}) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.yonghuCrossAddOrUpdateFlag = false;
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
            getUUID() {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.yonghuCrossAddOrUpdateFlag = false;
            },
        }
    };
</script>
<style lang="scss" scoped>
    .editor {
        height: 500px;
    }
</style>
