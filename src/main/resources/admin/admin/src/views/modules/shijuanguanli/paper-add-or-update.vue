<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-form-item label="试卷名称" prop="name">
        <el-input v-model="ruleForm.name" placeholder="试卷名称" clearable></el-input>
      </el-form-item>

      <el-form-item label="考试时长" prop="time">
        <el-input type="number" min="1" v-model="ruleForm.time" placeholder="考试时长（分钟）" clearable>
          <template slot="append">分钟</template>
        </el-input>
      </el-form-item>

      <el-form-item label="试卷状态" prop="status">
        <el-select v-model="ruleForm.status" placeholder="请选择状态">
          <el-option key="1" label="启用" :value="1"></el-option>
          <el-option key="0" label="禁用" :value="0"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
        <el-button @click="back()">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { isNumber } from "@/utils/validate";
export default {
  data() {
    var validateNumber = (rule, value, callback) => {
      if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {},
      rules: {
        name: [{ required: true, message: "名称不能为空", trigger: "blur" }],
        time: [
          { required: true, message: "考试时间不能为空", trigger: "blur" }
        ],
        status: [{ required: true, message: "状态不能为空", trigger: "blur" }]
      }
    };
  },
  props: ["parent"],
  methods: {
    // 初始化
    init(id) {
      if (id) {
        this.info(id);
      } else {
        this.ruleForm.created = new Date();
      }
    },
    info(id) {
      this.$http({
        url: `${this.$api.exampaperinfo}${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
          this.ruleForm.time = this.ruleForm.time/60;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    // 提交
    onSubmit() {
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.ruleForm.time = this.ruleForm.time*60;
          this.$http({
            url: `${!this.ruleForm.id ? `${this.$api.exampapersave}` : `${this.$api.exampaperupdate}`}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = false;
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
    // 返回
    back() {
      this.parent.showFlag = false;
    },
    shangpingmiaoshuInput(content) {
      this.ruleForm.shangpinmiaoshu = content;
    }
  }
};
</script>
<style lang="scss" scoped>
.editor {
  height: 500px;
}
</style>
