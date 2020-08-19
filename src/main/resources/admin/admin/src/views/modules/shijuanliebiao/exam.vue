<template>
  <div class="container">
    <div class="top-content">
      <div class="left-content">
        当前第
        <span class="tip-text">{{currentIndex+1}}</span> 道题。未答题目：
        <span class="tip-text">{{dataList.length - currentIndex-1}}</span> 道，总题目：
        <span class="tip-text">{{dataList.length}}</span> 道。
      </div>
      <div class="right-content">
        考试剩余时间：
        <span class="tip-text">{{SecondToDate}}</span>
      </div>
      <div class="right-content">
        <el-button type="danger" round @click="leaveTap">结束考试</el-button>
      </div>
    </div>
    <div class="detail-content" v-if="!isEndFlag">
      <div class="item-content">
        <span class="label">
          题目
          (
          <span v-if="ruleForm.type==0">单选题</span>
          <span v-if="ruleForm.type==1">多选题</span>
          <span v-if="ruleForm.type==2">判断题</span>
          <span v-if="ruleForm.type==3">填空题</span>
          )
          ({{ruleForm.score}}分)：
        </span>
        <span class="content">{{ruleForm.questionname}}</span>
      </div>
      <div
        v-if="(ruleForm.type==0||ruleForm.type==2)&&!isSubmitFlag"
        class="item-content"
        style="border-top:1px solid #eeeeee"
      >
        <span class="label">选择答案：</span>
        <span class="content">
          <el-select v-model="answer">
            <el-option
              :label="item.text"
              :value="item.code"
              v-for="(item,index) in options"
              v-bind:key="index"
            ></el-option>
          </el-select>
        </span>
      </div>
      <div
        v-if="ruleForm.type==3&&!isSubmitFlag"
        class="item-content"
        style="border-top:1px solid #eeeeee"
      >
        <span class="label">填写答案：</span>
        <span class="content">
          <el-input v-model="answer" style="width:300px" placeholder="填写答案" clearable></el-input>
        </span>
      </div>
      <div
        v-if="ruleForm.type==1&&!isSubmitFlag"
        class="item-content"
        style="border-top:1px solid #eeeeee"
      >
        <span class="label">选择答案：</span>
        <span class="content">
          <el-select v-model="answer" multiple>
            <el-option
              :label="item.text"
              :value="item.code"
              v-for="(item,index) in options"
              v-bind:key="index"
            ></el-option>
          </el-select>
        </span>
      </div>
      <div v-if="isSubmitFlag" class="item-content" style="border-top:1px solid #eeeeee">
        <span class="label">填写答案：</span>
        <span class="content">{{answer}}</span>
      </div>
      <div v-if="isSubmitFlag" class="item-content" style="color:#888888">
        <span
          class="label"
          style="color:red;margin-right:20px"
        >{{answer==this.ruleForm.answer?'正确':'错误'}}</span>
        <span class="label">解析：</span>
        <span class="content">{{ruleForm.analysis}}</span>
      </div>
      <div class="item-content" style="color:#888888">
        <el-button v-if="!isSubmitFlag" @click="submitTap" type="primary">提交答案</el-button>
        <el-button v-if="isSubmitFlag" @click="nextTap" type="success">下一题</el-button>
      </div>
    </div>
    <div class="detail-content" v-if="isEndFlag">
      <div class="item-content">
        <span class="label">
          考试成绩：
          <span style="font-size:24px;font-weight:blod;color:red">{{this.score}}</span>
        </span>
        <span class="content">分</span>
      </div>
      <div class="item-content" style="color:#888888">
        <el-button @click="finishTap" type="primary">结束考试</el-button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      dataList: [],
      // 当前题目
      paper: {},
      // 当前答题下标
      currentIndex: 0,
      ruleForm: {},
      // 倒计时定时器
      inter: null,
      // 倒计时时间
      count: 0,
      // 选项
      options: null,
      // 用户选择答案
      answer: "",
      // 是否提交点击下一题
      isSubmitFlag: false,
      // 得分
      score: 0,
      user: {},
      // 考试是否结束
      isEndFlag: false
    };
  },
  computed: {
    SecondToDate: function() {
      var time = this.count;
      if (null != time && "" != time) {
        if (time > 60 && time < 60 * 60) {
          time =
            parseInt(time / 60.0) +
            "分钟" +
            parseInt((parseFloat(time / 60.0) - parseInt(time / 60.0)) * 60) +
            "秒";
        } else if (time >= 60 * 60 && time < 60 * 60 * 24) {
          time =
            parseInt(time / 3600.0) +
            "小时" +
            parseInt(
              (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
            ) +
            "分钟" +
            parseInt(
              (parseFloat(
                (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
              ) -
                parseInt(
                  (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                )) *
                60
            ) +
            "秒";
        } else if (time >= 60 * 60 * 24) {
          time =
            parseInt(time / 3600.0 / 24) +
            "天" +
            parseInt(
              (parseFloat(time / 3600.0 / 24) - parseInt(time / 3600.0 / 24)) *
                24
            ) +
            "小时" +
            parseInt(
              (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
            ) +
            "分钟" +
            parseInt(
              (parseFloat(
                (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
              ) -
                parseInt(
                  (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                )) *
                60
            ) +
            "秒";
        } else {
          time = parseInt(time) + "秒";
        }
      }
      return time;
    }
  },
  destroyed: function() {
    window.clearInterval(this.inter);
  },
  mounted() {
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.user = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    console.log(this.$route.params.id);
    // 获取 试题
    var params = {
      page: 1,
      limit: 999,
      sort: "id",
      paperid: this.$route.params.id
    };
    this.$http({
      url: this.$api.examquestionpage,
      method: "get",
      params: params
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.dataList = data.data.list;
        this.ruleForm = this.dataList[this.currentIndex];
        this.options = JSON.parse(this.ruleForm.options);
      } else {
        this.dataList = [];
      }
      this.dataListLoading = false;
    });
    // 获取试卷
    this.$http({
      url: `${this.$api.exampaperinfo}${this.$route.params.id}`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.paper = data.data;
        if (this.paper.time) {
          this.count = this.paper.time;
          if (this.count > 0) {
            var _this = this;
            this.inter = window.setInterval(function() {
              _this.count = _this.count - 1;
              if (_this.count < 0) {
                window.clearInterval(_this.inter);
                _this.isEndFlag = true;
              }
            }, 1000);
          }
        }
      } else {
        this.$message.error(data.msg);
      }
    });
  },
  methods: {
    leaveTap() {
      this.$confirm(`确定离开考试?未答题目按0分计算`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.isEndFlag = true;
      });
    },
    finishTap() {
      this.$router.go(-1);
    },
    submitTap() {
      let myscore = 0;
      if (this.ruleForm.type == 1) {
        console.log(this.answer);
        this.answer = this.answer.join(",");
      }
      this.isSubmitFlag = true;
      if (this.answer == this.ruleForm.answer) {
        this.score = this.score + this.ruleForm.score;
        myscore = this.ruleForm.score;
      }
      console.log(this.score);
      // 保存答题记录
      let record = {
        userid: this.user.id,
        paperid: this.paper.id,
        papername: this.paper.name,
        questionid: this.ruleForm.id,
        questionname: this.ruleForm.questionname,
        options: this.ruleForm.options,
        score: this.ruleForm.score,
        answer: this.ruleForm.answer,
        analysis: this.ruleForm.analysis,
        myscore: myscore,
        myanswer: this.answer
      };
      this.$http({
        url: `${this.$api.examrecordsave}`,
        method: "post",
        data: record
      }).then(({ data }) => {});
    },
    nextTap() {
      if (this.currentIndex == this.dataList.length - 1) {
        this.isEndFlag = true;
      } else {
        this.currentIndex = this.currentIndex + 1;
        this.ruleForm = this.dataList[this.currentIndex];
        this.options = JSON.parse(this.ruleForm.options);
        this.isSubmitFlag = false;
      }
    }
  }
};
</script>
<style lang="scss" scoped>
.container {
  border: 1px solid #eeeeee;
}
.tip-text {
  font-size: 24px;
  color: #f96332;
}
.top-content {
  display: flex;
  justify-content: space-between;
  padding: 10px;
  font-size: 18px;
  background: #409eff;
  color: #ffffff;
  border-radius: 20px;
}
.detail-content {
  padding: 20px;
  color: #333333;
  .item-content {
    padding: 20px;
  }
}
</style>
