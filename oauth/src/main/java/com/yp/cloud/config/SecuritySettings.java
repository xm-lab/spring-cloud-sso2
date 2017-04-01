package com.yp.cloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="securityconfig")
public class SecuritySettings {
    private String logouturl = "/logout";
    private String permitall = "/api";

    public String getLogouturl() {
        return logouturl;
    }

    public void setLogouturl(String logouturl) {
        this.logouturl = logouturl;
    }

    public String getPermitall() {
        return permitall;
    }

    public void setPermitall(String permitall) {
        this.permitall = permitall;
    }
}
