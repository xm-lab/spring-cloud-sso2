package com.yp.cloud.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Administrator on 2017/3/30.
 */
@RestController
public class HomeController {

    @ApiOperation(value = "首页")
    @GetMapping("/")
    public Principal index(Principal user) {
        return user;
    }
}
