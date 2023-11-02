
<!-- 弹出框必须按照官方所写使用供的代码的确使用了 .sync 修饰符，这是因为在 Vue2 中，Element UI 的 el-dialog 组件使用 :visible.sync="dialogVisible" 来实现对话框的显示和隐藏。在 Vue3 和 Element Plus 中，虽然 v-model 是更推荐的方式，但 .sync 修饰符仍然可以使用。 -->
<!-- 但是v-model 可以工作，而且它是 Vue3 和 Element Plus 更推荐的方式，我建议你继续使用 v-model="dialogVisible"。这样你可以避免可能的兼容性问题，并且使你的代码更符合 Vue3 的设计理念。 -->
<!-- 所以使用前必须参照官方使用 -->
<template>
    <div class="user-list">
      <!-- 用户表格 -->
      <el-table :data="users" style="width: 100%">
        <el-table-column prop="id" label="ID"></el-table-column>
        <el-table-column prop="username" label="用户名"></el-table-column>
        <el-table-column prop="password" label="密码"></el-table-column>
        <el-table-column prop="name" label="姓名"></el-table-column>
        <el-table-column prop="phone" label="电话"></el-table-column>
        <el-table-column prop="email" label="邮箱"></el-table-column>
        <el-table-column prop="address" label="地址"></el-table-column>
        <el-table-column prop="avatar" label="头像"></el-table-column>
        <el-table-column label="操作">
          <template v-slot="{ row }">
            <el-button @click="editUser(row)" type="primary">编辑</el-button>
            <el-button @click="deleteUser(row.id)"  type="danger">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
  
      <!-- 添加和编辑用户的对话框 -->
      <el-dialog 
      v-model="dialogVisible" 
      title="用户信息" 
      :before-close="handleClose"
      >
        <el-form v-model="form">
          <el-form-item label="用户名">
            <el-input v-model="form.username" placeholder="用户名"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input type="password" v-model="form.password"></el-input>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="电话">
            <el-input v-model="form.phone"></el-input>
          </el-form-item>
          <el-form-item label="邮箱">
            <el-input v-model="form.email"></el-input>
          </el-form-item>
          <el-form-item label="地址">
            <el-input v-model="form.address"></el-input>
          </el-form-item>
          <el-form-item label="头像">
            <el-input v-model="form.avatar"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="saveUser">保存</el-button>
        </span>
      </el-dialog>
  
      <!-- 添加用户按钮 -->
      <el-button @click="addUser">添加用户</el-button>
    </div>
  </template>
  
  <script lang="ts" setup>
import { ref } from 'vue';
import axios from 'axios';
import { ElMessageBox } from 'element-plus'

const users = ref([]);
const dialogVisible = ref(false);
const form = ref({
  id: '',
  username: '',
  password: '',
  name: '',
  phone: '',
  email: '',
  address: '',
  avatar: '',
});

const fetchUsers = async () => {
  const response = await axios.get('http://localhost:9090/aops/user/all');
  users.value = response.data;
};

const addUser = () => {
  form.value = {
    id: '',
    username: '',
    password: '',
    name: '',
    phone: '',
    email: '',
    address: '',
    avatar: '',
  };
  dialogVisible.value = true;
};

const saveUser = async () => {
  if (form.value.id) {
    await axios.put(`http://localhost:9090/aops/user/${form.value.id}`, form.value);
  } else {
    await axios.post('http://localhost:9090/aops/user', form.value);
  }
  dialogVisible.value = false;
  await fetchUsers();
};

const editUser = (user) => {
  form.value = { ...user };
  dialogVisible.value = true;
};

const deleteUser = async (user) => {
  await axios.delete(`http://localhost:9090/aops/user/${user.id}`);
  await fetchUsers();
};

const handleClose = (done: () => void) => {
  ElMessageBox.confirm('Are you sure to close this dialog?')
    .then(() => {
      done()
    })
    .catch(() => {
      // catch error
    })
}



fetchUsers();
</script>

<style scoped>
.user-list {
  padding: 20px;
}
</style>