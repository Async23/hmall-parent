package com.itheima.web;

import com.itheima.Service.UserService;
import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据用户 id 查询用户
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id) {
        return userService.queryById(id);
    }
}
