package com.yp.cloud.controller;

import com.yp.cloud.entity.User;
import com.yp.cloud.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/29.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "测试post方法,测试权限")
    @PreAuthorize("hasAnyAuthority({'admin'})")
    @PostMapping("/user")
    public User getUserInfo(@RequestParam String name) {
        User user = userRepository.findByName(name);
        return user;
    }

    @ApiOperation(value = "测试get方法")
    @PreAuthorize("hasAnyAuthority({'user'})")
    @GetMapping("/user/test")
    public String test() {
        return "this is a test message!!!";
    }

    @ApiOperation(value = "登录")
    @PostMapping(value = "/user/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void login(@RequestParam String username, @RequestParam String password) {

    }

    @ApiOperation(value = "退出")
    @PostMapping(value = "/user/logout")
    public void login() {
    }
}
