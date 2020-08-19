const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [{"buttons": ["新增", "查看", "修改", "删除"], "menu": "用户列表", "tableName": "yonghu"}],
                "menu": "用户管理"
            }, {
                "child": [{"buttons": ["新增", "查看", "修改", "删除"], "menu": "企业信息列表", "tableName": "qiyexinxi"}],
                "menu": "企业信息管理"
            }, {
                "child": [{"buttons": ["新增", "查看", "修改", "删除"], "menu": "岗位分类列表", "tableName": "gangweifenlei"}],
                "menu": "岗位分类管理"
            }, {
                "child": [{"buttons": ["新增", "查看", "修改", "删除"], "menu": "学历信息列表", "tableName": "xuelixinxi"}],
                "menu": "学历信息管理"
            }, {
                "child": [{"buttons": ["新增", "查看", "修改", "删除"], "menu": "友情链接列表", "tableName": "youqinglianjie"}],
                "menu": "友情链接管理"
            }, {
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "配置管理",
                    "tableName": "peizhiguanli"
                }, {"buttons": ["新增", "查看", "修改", "删除"], "menu": "新闻资讯列表", "tableName": "news"}], "menu": "系统管理"
            }, {
                "child": [{"buttons": ["新增", "查看", "修改", "删除"], "menu": "收藏列表", "tableName": "storeup"}],
                "menu": "我的收藏管理"
            }, {
                "child": [{"buttons": ["新增", "查看", "修改", "删除"], "menu": "管理员管理", "tableName": "users"}],
                "menu": "管理员管理"
            }, {
                "child": [{"buttons": ["查看", "修改", "删除"], "menu": "招聘信息列表", "tableName": "zhaopinxinxi"}],
                "menu": "招聘信息管理"
            }, {
                "child": [{"buttons": ["查看", "删除"], "menu": "应聘信息列表", "tableName": "yingpinxinxi"}],
                "menu": "应聘信息管理"
            }, {
                "child": [{"buttons": ["查看", "修改", "删除"], "menu": "求职者信息列表", "tableName": "qiuzhizhexinxi"}],
                "menu": "求职者信息管理"
            }],
            "frontMenu": [{
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除", "应聘"],
                    "menu": "招聘信息列表",
                    "tableName": "zhaopinxinxi"
                }], "menu": "招聘信息模块"
            }, {
                "child": [{"buttons": ["新增", "查看", "修改", "删除"], "menu": "求职者信息列表", "tableName": "qiuzhizhexinxi"}],
                "menu": "求职者信息模块"
            }, {
                "child": [{"buttons": ["新增", "查看", "修改", "删除"], "menu": "友情链接列表", "tableName": "youqinglianjie"}],
                "menu": "友情链接模块"
            }],
            "roleName": "管理员",
            "tableName": "users"
        }, {
            "backMenu": [{
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "求职者信息列表",
                    "tableName": "qiuzhizhexinxi"
                }], "menu": "求职者信息管理"
            }, {"child": [{"buttons": ["查看"], "menu": "应聘信息列表", "tableName": "yingpinxinxi"}], "menu": "应聘信息管理"}],
            "frontMenu": [{
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除", "应聘"],
                    "menu": "招聘信息列表",
                    "tableName": "zhaopinxinxi"
                }], "menu": "招聘信息模块"
            }, {
                "child": [{"buttons": ["新增", "查看", "修改", "删除"], "menu": "求职者信息列表", "tableName": "qiuzhizhexinxi"}],
                "menu": "求职者信息模块"
            }, {
                "child": [{"buttons": ["新增", "查看", "修改", "删除"], "menu": "友情链接列表", "tableName": "youqinglianjie"}],
                "menu": "友情链接模块"
            }],
            "roleName": "用户",
            "tableName": "yonghu"
        }, {
            "backMenu": [{
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "招聘信息列表",
                    "tableName": "zhaopinxinxi"
                }], "menu": "招聘信息管理"
            }, {
                "child": [{"buttons": ["查看", "删除", "审核"], "menu": "应聘信息列表", "tableName": "yingpinxinxi"}],
                "menu": "应聘信息管理"
            }],
            "frontMenu": [{
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除", "应聘"],
                    "menu": "招聘信息列表",
                    "tableName": "zhaopinxinxi"
                }], "menu": "招聘信息模块"
            }, {
                "child": [{"buttons": ["新增", "查看", "修改", "删除"], "menu": "求职者信息列表", "tableName": "qiuzhizhexinxi"}],
                "menu": "求职者信息模块"
            }, {
                "child": [{"buttons": ["新增", "查看", "修改", "删除"], "menu": "友情链接列表", "tableName": "youqinglianjie"}],
                "menu": "友情链接模块"
            }],
            "roleName": "企业",
            "tableName": "qiyexinxi"
        }]
    }
}
export default menu;
