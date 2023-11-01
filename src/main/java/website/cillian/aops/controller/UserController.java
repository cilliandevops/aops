package website.cillian.aops.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.cillian.aops.common.Result;
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


    @GetMapping("/all")
    public List<User> listAllUsers() {
        return userService.list(); // 使用MyBatis Plus提供的list()方法查询所有用户
    }

}
