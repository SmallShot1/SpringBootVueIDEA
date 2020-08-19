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
                    <el-form-item v-if="type!='info'" label="网站名称" prop="wangzhanmingcheng">
                        <el-input v-model="ruleForm.wangzhanmingcheng"
                                  placeholder="网站名称" clearable></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.wangzhanmingcheng" label="网站名称" prop="wangzhanmingcheng">
                            <el-input v-model="ruleForm.wangzhanmingcheng"
                                      placeholder="网站名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'" label="logo" prop="logo">
                        <file-upload
                                tip="点击上传logo"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.logo?ruleForm.logo:''"
                                @change="logoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.logo" label="logo" prop="logo">
                            <img style="margin-right:20px;" v-bind:key="index"
                                 v-for="(item,index) in ruleForm.logo.split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item v-if="type!='info'" label="网址" prop="wangzhi">
                        <el-input v-model="ruleForm.wangzhi"
                                  placeholder="网址" clearable></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.wangzhi" label="网址" prop="wangzhi">
                            <el-input v-model="ruleForm.wangzhi"
                                      placeholder="网址" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'" label="网站介绍" prop="wangzhanjieshao">
                        <editor
                                style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.wangzhanjieshao"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.wangzhanjieshao" label="网站介绍" prop="wangzhanjieshao">
                            <span v-html="ruleForm.wangzhanjieshao"></span>
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
                    wangzhanmingcheng: '',
                    logo: '',
                    wangzhi: '',
                    wangzhanjieshao: '',
                },
                rules: {
                    wangzhanmingcheng: [],
                    logo: [],
                    wangzhi: [],
                    wangzhanjieshao: [],
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
                        if (o == 'wangzhanmingcheng') {
                            this.ruleForm.wangzhanmingcheng = obj[o];
                            continue;
                        }
                        if (o == 'logo') {
                            this.ruleForm.logo = obj[o];
                            continue;
                        }
                        if (o == 'wangzhi') {
                            this.ruleForm.wangzhi = obj[o];
                            continue;
                        }
                        if (o == 'wangzhanjieshao') {
                            this.ruleForm.wangzhanjieshao = obj[o];
                            continue;
                        }
                    }
                }
            },
            // 多级联动参数
            info(id) {
                this.$http({
                    url: `youqinglianjie/info/${id}`,
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
                            url: `youqinglianjie/${!this.ruleForm.id ? "save" : "update"}`,
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
                                        this.parent.youqinglianjieCrossAddOrUpdateFlag = false;
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
                this.parent.youqinglianjieCrossAddOrUpdateFlag = false;
            },
            logoUploadChange(fileUrls) {
                this.ruleForm.logo = fileUrls;
            },
        }
    };
</script>
<style lang="scss" scoped>
    .editor {
        height: 500px;
    }
</style>
