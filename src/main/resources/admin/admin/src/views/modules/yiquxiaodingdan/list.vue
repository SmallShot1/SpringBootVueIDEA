<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="!showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-form-item label="商品名称">
          <el-input v-model="searchForm.goodname" placeholder="商品名称" clearable></el-input>
        </el-form-item>
        <el-form-item label="订单编号">
          <el-input v-model="searchForm.orderid" placeholder="订单编号" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-button round @click="search()">查询</el-button>
        </el-form-item>
      </el-form>
      <div class="table-content">
        <el-table
          :data="dataList"
          border
          v-loading="dataListLoading"
          @selection-change="selectionChangeHandler"
          style="width: 100%;"
        >
          <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
          <el-table-column
            prop="orderid"
            header-align="center"
            align="center"
            sortable
            label="订单编号"
          ></el-table-column>
          <el-table-column
            prop="goodname"
            header-align="center"
            align="center"
            sortable
            label="商品名称"
          ></el-table-column>
          <el-table-column
            prop="picture"
            header-align="center"
            align="center"
            sortable
            label="商品图片"
          >
            <template slot-scope="scope">
              <img :src="scope.row.picture" style="width:80px">
            </template>
          </el-table-column>
          <el-table-column
            prop="buynumber"
            header-align="center"
            align="center"
            sortable
            label="购买数量"
          ></el-table-column>
          <el-table-column
            prop="price"
            header-align="center"
            align="center"
            sortable
            label="价格/积分"
          ></el-table-column>
          <el-table-column
            prop="total"
            header-align="center"
            align="center"
            sortable
            label="总价格/总积分"
          ></el-table-column>
          <el-table-column
            prop="discounttotal"
            header-align="center"
            align="center"
            sortable
            label="折扣总价格"
          ></el-table-column>
          <el-table-column
            prop="type"
            header-align="center"
            align="center"
            sortable
            label="支付类型"
          >
            <template slot-scope="scope">
              <el-tag v-if="scope.row.type=='1'" type="success">现金</el-tag>
              <el-tag v-if="scope.row.type=='2'" type="info">积分</el-tag>
            </template>
          </el-table-column>
          <el-table-column
            prop="status"
            header-align="center"
            align="center"
            sortable
            label="状态"
          ></el-table-column>
          <el-table-column
            prop="address"
            header-align="center"
            align="center"
            sortable
            label="地址"
          ></el-table-column>
          <el-table-column
            fixed="right"
            header-align="center"
            align="center"
            label="操作"
          >
            <template slot-scope="scope">
              <el-button
                type="text"
                icon="el-icon-edit"
                size="small"
                @click="addOrUpdateHandler(scope.row.id)"
              >查看</el-button>
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
import AddOrUpdate from "./order-add-or-update";
export default {
  data() {
    return {
      searchForm: {
        goodname: ""
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: false
    };
  },
  mounted() {
    this.init();
    this.getDataList();
  },
  components: {
    AddOrUpdate
  },
  methods: {
    init() {},
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      var params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: "id",
        status: "已取消"
      };
      if (this.searchForm.goodname) {
        params["goodname"] = `%${this.searchForm.goodname}%`;
      }
      if (this.searchForm.orderid) {
        params["orderid"] = `%${this.searchForm.orderid}%`;
      }
      this.$http({
        url: this.$api.orderpage,
        method: "get",
        params: params
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
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id) {
      this.showFlag = true;
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id);
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
          url: this.$api.orderdelete,
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
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
