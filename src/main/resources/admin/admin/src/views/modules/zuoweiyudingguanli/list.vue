<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="!showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-form-item>
          <el-button type="primary" @click="addOrUpdateHandler()" round>新增</el-button>
          <el-button
            :disabled="dataListSelections.length <= 0"
            type="danger"
            @click="deleteHandler()"
            round
          >删除</el-button>
        </el-form-item>
      </el-form>
      <div class="table-content">
        <el-table
          @selection-change="selectionChangeHandler"
          :data="dataList"
          border
          v-loading="dataListLoading"
          style="width: 100%;"
        >
          <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
          <el-table-column
            width="80"
            prop="id"
            header-align="center"
            align="center"
            sortable
            label="id"
          ></el-table-column>
          <el-table-column
            width="150"
            prop="name"
            header-align="center"
            align="center"
            sortable
            label="电影名称"
          ></el-table-column>
          <el-table-column
            width="100"
            prop="address"
            header-align="center"
            align="center"
            sortable
            label="电影厅"
          ></el-table-column>
          <el-table-column
            prop="name"
            width="130"
            header-align="center"
            align="center"
            sortable
            label="电影封面"
          >
            <template slot-scope="scope">
              <img :src="scope.row.picture" style="width:80px">
            </template>
          </el-table-column>
          <el-table-column
            width="150"
            prop="status"
            header-align="center"
            align="center"
            sortable
            label="状态"
          >
            <template slot-scope="scope">
              <el-tag v-if="scope.row.status=='上线'" type="success">上线</el-tag>
              <el-tag v-if="scope.row.status=='下线'" type="info">下线</el-tag>
            </template>
          </el-table-column>
          <el-table-column
            width="150"
            prop="description"
            header-align="center"
            align="center"
            sortable
            label="描述"
          ></el-table-column>
          <el-table-column
            width="120"
            prop="number"
            header-align="center"
            align="center"
            sortable
            label="座位总数"
          ></el-table-column>
          <el-table-column
            width="120"
            prop="starttime"
            header-align="center"
            align="center"
            sortable
            label="开始时间"
          ></el-table-column>
          <el-table-column
            width="120"
            prop="endtime"
            header-align="center"
            align="center"
            sortable
            label="结束时间"
          ></el-table-column>
          <el-table-column
            width="140"
            prop="duration"
            header-align="center"
            align="center"
            sortable
            label="持续时间/分钟"
          ></el-table-column>
          <el-table-column
            width="140"
            prop="selected"
            header-align="center"
            align="center"
            sortable
            label="已选座位"
          ></el-table-column>

          <el-table-column
            fixed="right"
            header-align="center"
            align="center"
            width="150"
            label="操作"
          >
            <template slot-scope="scope">
              <el-button
                type="text"
                icon="el-icon-edit"
                size="small"
                @click="addOrUpdateHandler(scope.row)"
              >修改</el-button>
              <el-button
                type="text"
                icon="el-icon-delete"
                size="small"
                @click="deleteHandler(scope.row.id)"
              >删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="pageSize"
          :total="totalPage"
          layout="total, sizes, prev, pager, next, jumper"
          class="pagination-content"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
    <add-or-update v-else :parent="this" ref="addOrUpdate"></add-or-update>
  </div>
</template>
<script>
import AddOrUpdate from "./restaurant-seat-add-or-update";
export default {
  data() {
    return {
      searchForm: {},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      showFlag: false,
      dataListSelections: []
    };
  },
  mounted() {
    this.getDataList();
  },
  components: {
    AddOrUpdate
  },
  methods: {
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      this.$http({
        url: this.$api.seatspage,
        method: "get",
        params: {
          page: this.pageIndex,
          limit: this.pageSize,
          sort: 'id'
        }
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 添加/修改
    addOrUpdateHandler(row) {
      this.showFlag = true;
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(row?row.id:'');
      });
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: this.$api.seatsdelete,
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
