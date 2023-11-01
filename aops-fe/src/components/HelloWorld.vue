<template>
  <div class="common-layout">
    <el-container style="height: 100vh;">
      <el-aside width="200px">
        <div style="height: 60px; color: rgb(41, 74, 223); display: flex; align-items: center; justify-content: center">
          <img src="../assets/vue.svg" alt="" style="width: 50px; height: 50px">
          <span class="logo-title" >Aops</span>
        </div>
        <el-radio-group v-model="isCollapse" style="margin-bottom: 20px">
        <el-radio-button :label="false">expand</el-radio-button>
        <el-radio-button :label="true">collapse</el-radio-button>
        </el-radio-group>
        <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        :collapse="isCollapse"
        @open="handleOpen"
        @close="handleClose"
        >
          <el-sub-menu index="1">
            <template #title>
              <el-icon><location /></el-icon>
              <span>Navigator One</span>
            </template>
            <el-menu-item-group>
              <template #title><span>Group One</span></template>
              <el-menu-item index="1-1">item one</el-menu-item>
              <el-menu-item index="1-2">item two</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group Two">
              <el-menu-item index="1-3">item three</el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="1-4">
              <template #title><span>item four</span></template>
              <el-menu-item index="1-4-1">item one</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-menu-item index="2">
            <el-icon><icon-menu /></el-icon>
            <template #title>Navigator Two</template>
          </el-menu-item>
          <el-menu-item index="3" disabled>
            <el-icon><document /></el-icon>
            <template #title>Navigator Three</template>
          </el-menu-item>
          <el-menu-item index="4">
            <el-icon><setting /></el-icon>
            <template #title>Navigator Four</template>
          </el-menu-item>
        </el-menu>
        这里是Aside
      </el-aside>
      <el-container>
        <el-header>这里是Header</el-header>
        <el-main>
          <el-card style="text-align: center ;">这里是Main</el-card>
          <div style="box-shadow: 0 0 10px rgba(0,0,0,.1); padding: 10px 20px; border-radius: 5px; margin-bottom: 10px">
          希里安！您好！世界！
          </div>
          <el-card >
            <div slot="header" class="clearfix">
              <span>Aops！这是一个Vue3+springboot前后端分离快速开始的模板应用</span>
            </div>
            
            <div>
              
              <div style="margin-top: 20px">
                <div style="margin: 10px 0"><strong>颜色</strong></div>
                <el-button type="primary">按钮</el-button>
                <el-button type="success">按钮</el-button>
                <el-button type="warning">按钮</el-button>
                <el-button type="danger">按钮</el-button>
                <el-button type="info">按钮</el-button>
              </div>
            </div>
          </el-card>

          
        </el-main>
        
        <el-footer class="footer">
                    <el-icon style="width:2em;top:3px;font-size:18px"><place/></el-icon>
                    <a class="footer el-icon-place">这里是Footer@2023</a>
        </el-footer>
      </el-container>
    </el-container>
  </div>
</template>
<style>
  .el-header, .el-footer {
    background-color: rgb(140, 172, 211);
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #accff7;
    color: #333;
    text-align: center;
    /* line-height: 200px; */
  }
  

  

</style>
<script lang="ts" setup>
import { ref } from 'vue'
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'

const isCollapse = ref(true)
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>