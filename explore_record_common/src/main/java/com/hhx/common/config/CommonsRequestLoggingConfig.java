package com.hhx.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;


/**
 * @author sunyuanhui
 */
@Configuration
@ConditionalOnWebApplication
public class CommonsRequestLoggingConfig {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter() {
            @Override
            protected boolean shouldLog(HttpServletRequest request) {
                return true;
            }
            @Override
            protected void beforeRequest(HttpServletRequest request, @Nullable String message) {
                this.logger.info(message);
                log.info("==============REQUEST{}==============", request.getRequestURI());
            }
            @Override
            protected void afterRequest(HttpServletRequest request, @Nullable String message) {
                this.logger.info(message);
                 log.info("==============REQUEST DATA:{}==============", message);
            }
        };
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        filter.setAfterMessagePrefix("REQUEST DATA : ");
        return filter;
    }
}
