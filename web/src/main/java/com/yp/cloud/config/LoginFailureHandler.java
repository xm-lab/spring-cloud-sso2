package com.yp.cloud.config;

import com.yp.cloud.entity.User;
import com.yp.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/30.
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json;charset=UTF-8");

//        String username = httpServletRequest.getQueryString().substring(9,20);
//        System.err.println("username test: "+username);
//        User user = userRepository.findByName(username);
//        System.err.println("username get: "+user);
//        if (user == null) {
//            httpServletResponse.getWriter().write("{\"code\":0,\"message\":\"该手机号未注册\"}");
//        } else {
        httpServletResponse.getWriter().write("{\"code\":0,\"message\":\"登陆失败!\"}");
//        }
    }
}
