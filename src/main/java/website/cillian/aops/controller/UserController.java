package website.cillian.aops.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import website.cillian.aops.entity.User;
import website.cillian.aops.service.UserService;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author cillian
 * @since 2023-10-30 04:44:39
 */
@RestController
@RequestMapping("/aops/user")
public class UserController {
    @Autowired
    UserService userService;


    // 处理获取所有用户的请求
    @GetMapping("/all")
    public List<User> getAllUsers() {

        return userService.list();
    }

    // 处理添加新用户的请求
    @PostMapping
    public boolean addUser(@RequestBody User user) {

        return userService.save(user);
    }

    // 处理更新用户信息的请求
    @PutMapping("/{id}")
    public boolean updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        return userService.updateById(user);
    }

    // 处理删除用户的请求
    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Integer id) {
        return userService.removeById(id);
    }

}
