<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-form-item label="电影名称" prop="name">
        <el-input v-model="ruleForm.name" placeholder="电影名称" clearable></el-input>
      </el-form-item>
      <el-form-item label="电影厅" prop="address">
        <el-input v-model="ruleForm.address" placeholder="电影厅" clearable></el-input>
      </el-form-item>
      <el-form-item label="电影封面" prop="picture">
        <file-upload
          tip="点击上传电影封面"
          action="file/upload"
          :limit="1"
          :multiple="true"
          :fileUrls="ruleForm.picture?ruleForm.picture:''"
          @change="pictureUploadChange"
        ></file-upload>
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="ruleForm.status" placeholder="请选择状态">
          <el-option key="上线" label="上线" value="上线"></el-option>
          <el-option key="下线" label="下线" value="下线"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="描述" prop="description">
        <el-input
          style="width:600px;"
          type="textarea"
          v-model="ruleForm.description"
          placeholder="描述"
          clearable
        ></el-input>
      </el-form-item>
      <el-form-item label="座位总数" prop="number">
        <el-input-number v-model="ruleForm.number" :min="1" label="座位总数"></el-input-number>
      </el-form-item>
      <el-form-item label="开始时间" prop="starttime">
        <el-time-picker
          value-format="hh:mm:ss"
          v-model="ruleForm.starttime"
          placeholder="开始时间"
        ></el-time-picker>
      </el-form-item>
      <el-form-item label="结束时间" prop="endtime">
        <el-time-picker  
          value-format="hh:mm:ss"
          v-model="ruleForm.endtime"
          placeholder="结束时间"
        ></el-time-picker>
      </el-form-item>
      <el-form-item label="持续时间" prop="duration">
        <el-input v-model="ruleForm.duration" placeholder="持续时间" clearable>
          <template slot="append">分钟</template>
        </el-input>
      </el-form-item>
      <el-form-item label="已选座位" prop="selected">
        <el-input v-model="ruleForm.selected" placeholder="已选座位" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
        <el-button @click="back()">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {},
      rules: {
        name: [
          { required: true, message: "电影名称不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "电影厅不能为空", trigger: "blur" }
        ],
        picture: [
          { required: true, message: "电影封面不能为空", trigger: "blur" }
        ],
        description: [
          { required: true, message: "描述不能为空", trigger: "blur" }
        ],
        status: [{ required: true, message: "状态不能为空", trigger: "blur" }],
        number: [
          { required: true, message: "座位总数不能为空", trigger: "blur" }
        ],
        starttime: [
          { required: true, message: "开始时间不能为空", trigger: "blur" }
        ],
        endtime: [
          { required: true, message: "结束时间不能为空", trigger: "blur" }
        ],
        duration: [
          { required: true, message: "持续时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  props: ["parent"],
  methods: {
    // 初始化
    init(id) {
      if (id) {
        this.$http({
          url: `${this.$api.seatsinfo}${id}`,
          method: "get"
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.ruleForm = data.seat;
          } else {
            this.$message.error(data.msg);
          }
        });
      }
    },
    // 提交
    onSubmit() {
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `${!this.ruleForm.id ? `${this.$api.seatssave}` : `${this.$api.seatsupdate}`}`,
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
    pictureUploadChange(fileUrls) {
      this.ruleForm.picture = fileUrls;
    }
  }
};
</script>
<style lang="scss" scoped>
.editor {
  height: 500px;
}
</style>
