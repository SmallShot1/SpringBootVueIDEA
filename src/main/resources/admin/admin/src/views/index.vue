<template>
  <el-container>
    <index-header></index-header>
    <el-container>
      <index-aside></index-aside>
      <index-main></index-main>
    </el-container>
  </el-container>
  <!-- <el-container>
    <index-aside></index-aside>
    <el-containe>
      <index-header></index-header>
      <index-main></index-main>
    </el-containe>
  </el-container> -->
</template>
<script>
import IndexHeader from '@/components/index/IndexHeader'
import IndexAside from '@/components/index/IndexAsideStatic'
import IndexMain from '@/components/index/IndexMain'
export default {
  components:{
    IndexAside,
    IndexHeader,
    IndexMain
  }
}
</script>

<style lang="scss" scoped>
// 铺满全屏
.el-container {
  position: absolute;
  width: 100%;
  top: 0;
  left: 0;
  bottom: 0;
}
</style>
