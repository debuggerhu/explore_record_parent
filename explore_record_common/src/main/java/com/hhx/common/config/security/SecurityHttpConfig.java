package com.hhx.common.config.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * @Author su Lichen
 * @Date 2020/6/10 17:14
 */
public interface SecurityHttpConfig {

    void configure(AuthenticationManagerBuilder auth);

    /**
     * 用于security的http请求配置
     *
     * @param http http
     * @throws Exception
     */
    void configure(HttpSecurity http) throws Exception;
}
