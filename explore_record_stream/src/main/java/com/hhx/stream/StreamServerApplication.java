package com.hhx.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author huhaixaing
 * @date 2020/7/28 17:56
 * @Description: com.hhc.stream
 */

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class StreamServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamServerApplication.class,args);
    }
}
