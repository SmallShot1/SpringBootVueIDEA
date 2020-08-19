<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
                                                              <el-form-item label="企业名称">
                <el-input v-model="searchForm.qiyemingcheng" 
                    placeholder="企业名称" clearable></el-input>
              </el-form-item>
                                                                                                      <el-form-item label="招聘岗位">
                <el-input v-model="searchForm.zhaopingangwei" 
                    placeholder="招聘岗位" clearable></el-input>
              </el-form-item>
                                                                                    <el-form-item label="岗位类别">
                <el-input v-model="searchForm.gangweileibie" 
                    placeholder="岗位类别" clearable></el-input>
              </el-form-item>
                                                                  <el-form-item label="学历">
                <el-input v-model="searchForm.xueli" 
                    placeholder="学历" clearable></el-input>
              </el-form-item>
                                                                                                                                <el-form-item>
          <el-button round @click="search()">查询</el-button>
          <el-button
            v-if="isAuth('zhaopinxinxi','新增')"
            type="primary"
            @click="addOrUpdateHandler()"
            round
          >新增</el-button>
          <el-button
            v-if="isAuth('zhaopinxinxi','删除')"
            :disabled="dataListSelections.length <= 0"
            type="danger"
            @click="deleteHandler()"
            round
          >删除</el-button>
                  </el-form-item>
      </el-form>
      <div class="table-content">
        <el-table
            v-if="isAuth('zhaopinxinxi','查看')"
            :data="dataList"
            border
            v-loading="dataListLoading"
            @selection-change="selectionChangeHandler"
            style="width: 100%;">
            <el-table-column
                type="selection"
                header-align="center"
                align="center"
                width="50">
            </el-table-column>
                                            <el-table-column
                    prop="qiyebianhao"
                    header-align="center"
                    align="center"
                    sortable
                    label="企业编号">
                    <template slot-scope="scope">
                      {{scope.row.qiyebianhao}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="qiyemingcheng"
                    header-align="center"
                    align="center"
                    sortable
                    label="企业名称">
                    <template slot-scope="scope">
                      {{scope.row.qiyemingcheng}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="fuzeren"
                    header-align="center"
                    align="center"
                    sortable
                    label="负责人">
                    <template slot-scope="scope">
                      {{scope.row.fuzeren}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="lianxidianhua"
                    header-align="center"
                    align="center"
                    sortable
                    label="联系电话">
                    <template slot-scope="scope">
                      {{scope.row.lianxidianhua}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="zhaopingangwei"
                    header-align="center"
                    align="center"
                    sortable
                    label="招聘岗位">
                    <template slot-scope="scope">
                      {{scope.row.zhaopingangwei}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="zhaopinrenshu"
                    header-align="center"
                    align="center"
                    sortable
                    label="招聘人数">
                    <template slot-scope="scope">
                      {{scope.row.zhaopinrenshu}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="gangweileibie"
                    header-align="center"
                    align="center"
                    sortable
                    label="岗位类别">
                    <template slot-scope="scope">
                      {{scope.row.gangweileibie}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="xueli"
                    header-align="center"
                    align="center"
                    sortable
                    label="学历">
                    <template slot-scope="scope">
                      {{scope.row.xueli}}
                    </template>
                </el-table-column>
                                                              <el-table-column prop="tupian" 
                    header-align="center"
                    align="center" 
                    width="200" 
                    label="图片">
                    <template slot-scope="scope">
                      <div v-if="scope.row.tupian">
                        <img :src="scope.row.tupian.split(',')[0]" min-width="100" height="100">
                      </div>
                      <div v-else>无图片</div>
                    </template>
                  </el-table-column>
                                                            <el-table-column
                    prop="gangweiyaoqiu"
                    header-align="center"
                    align="center"
                    sortable
                    label="岗位要求">
                    <template slot-scope="scope">
                      {{scope.row.gangweiyaoqiu}}
                    </template>
                </el-table-column>
                                                                                                                                                                                        <el-table-column
                header-align="center"
                align="center"
                label="操作">
                <template slot-scope="scope">
                                <el-button v-if="isAuth('zhaopinxinxi','查看')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
                                                                <el-button v-if="isAuth('zhaopinxinxi','应聘')" type="text" icon="el-icon-edit" size="small" @click="yingpinxinxiCrossAddOrUpdateHandler(scope.row,'cross')">应聘</el-button>
                                                                <el-button v-if="isAuth('zhaopinxinxi','修改')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>
                <el-button v-if="isAuth('zhaopinxinxi','删除')" type="text" icon="el-icon-delete" size="small" @click="deleteHandler(scope.row.id)">删除</el-button>
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
    <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

            <yingpinxinxi-cross-add-or-update v-if="yingpinxinxiCrossAddOrUpdateFlag" :parent="this" ref="yingpinxinxiCrossaddOrUpdate"></yingpinxinxi-cross-add-or-update>
        
    
    
  </div>
</template>
<script>
import AddOrUpdate from "./add-or-update";
import yingpinxinxiCrossAddOrUpdate from "../yingpinxinxi/add-or-update";
export default {
  data() {
    return {
                                                                                                                                                                  gangweileibieOptions: [],
                                          xueliOptions: [],
                                                                                                                  searchForm: {
        key: ""
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag:false,
                  yingpinxinxiCrossAddOrUpdateFlag: false,
                };
  },
  mounted() {
    this.init();
    this.getDataList();
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
            yingpinxinxiCrossAddOrUpdate,
          },
  methods: {
            yingpinxinxiCrossAddOrUpdateHandler(row,type){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.yingpinxinxiCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','zhaopinxinxi');
      this.$nextTick(() => {
        this.$refs.yingpinxinxiCrossaddOrUpdate.init(row.id,type);
      });
    },
                    init () {
                                                                                                                                  this.$http({
            url: `option/gangweifenlei/gangweileibie`,
            method: "get"
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.gangweileibieOptions = data.data;
            } else {
              this.$message.error(data.msg);
            }
          });
                                            this.$http({
            url: `option/xuelixinxi/xueli`,
            method: "get"
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.xueliOptions = data.data;
            } else {
              this.$message.error(data.msg);
            }
          });
                                                                                                                                                                                                                                                                                },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
      }
                                                                if(this.searchForm.qiyemingcheng!='' && this.searchForm.qiyemingcheng!=undefined){
            params['qiyemingcheng'] = '%' + this.searchForm.qiyemingcheng + '%'
          }
                                                                                                        if(this.searchForm.zhaopingangwei!='' && this.searchForm.zhaopingangwei!=undefined){
            params['zhaopingangwei'] = '%' + this.searchForm.zhaopingangwei + '%'
          }
                                                                                  if(this.searchForm.gangweileibie!='' && this.searchForm.gangweileibie!=undefined){
            params['gangweileibie'] = '%' + this.searchForm.gangweileibie + '%'
          }
                                                            if(this.searchForm.xueli!='' && this.searchForm.xueli!=undefined){
            params['xueli'] = '%' + this.searchForm.xueli + '%'
          }
                                                                                                                                            this.$http({
        url: "zhaopinxinxi/page",
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
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
        // 下载
    download(file){
      window.open(`${file}`)
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
          url: "zhaopinxinxi/delete",
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
