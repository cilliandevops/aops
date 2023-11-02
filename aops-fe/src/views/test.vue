// 在Vue3组件中使用Element Plus组件（假设是一个表格组件）
//基础使用方法
<template>
  <el-table
    :data="tableData"
    style="width: 100%">
    <el-table-column
      prop="date"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址">
    </el-table-column>
  </el-table>
</template>

<script>
import { ref } from 'vue';
import axios from 'axios';

export default {
  setup() {
    const tableData = ref([]);
    axios.get('http://localhost:9090/aops/user/all').then(response => {
      tableData.value = response.data;
    });
    return { tableData,showDialog };
  }
}
</script>
