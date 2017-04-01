package com.yp.cloud.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/29.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @ApiOperation(value = "测试get方法")
    @PreAuthorize("hasAnyAuthority({'user'})")
    @GetMapping("/test")
    public String test() {
        return "this is a test message!!!";
    }
}
