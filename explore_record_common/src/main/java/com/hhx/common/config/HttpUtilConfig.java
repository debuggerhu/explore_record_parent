package com.hhx.common.config;

import com.hhx.common.utils.HttpUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpUtilConfig {

    final RestTemplate restTemplate;

    public HttpUtilConfig(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Bean
    public HttpUtil httpUtil() {
        return new HttpUtil(restTemplate);
    }


}
