package com.yp.cloud.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/31.
 */
@RestController
public class HomeController {

    @ApiOperation(value = "首页")
    @GetMapping("/")
    public String index() {
        return "this is index page!!!";
    }
}
