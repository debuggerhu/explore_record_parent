package com.hhx.common.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @Author su Lichen
 * @Date 2020/5/18 11:50
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Resource
    private SecurityHttpConfig securityHttpConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        securityHttpConfig.configure(http);

        //多服务统一配置
        http.authorizeRequests()
                .antMatchers(
                        "/fegin/**",
                        "/rpc/**",
                        "/actuator/info"
                ).permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(new JwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        http.exceptionHandling().authenticationEntryPoint(new JwtAuthenticationEntryPoint());

        //关闭csrf防御，避免post请求出现403异常
        http.csrf().disable();
    }

}
