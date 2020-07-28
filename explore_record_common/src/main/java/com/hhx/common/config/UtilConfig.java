package com.hhx.common.config;

import com.hhx.common.utils.HttpUtil;
import com.hhx.common.utils.OAuth2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilConfig {

    final HttpUtil httpUtil;

    public UtilConfig(HttpUtil httpUtil) {
        this.httpUtil = httpUtil;
    }

    @Bean
    public OAuth2 oAuth2() {
        return new OAuth2(httpUtil);
    }
}
