package com.rbc.cloud.user;


import com.rbc.cloud.common.handler.FeignConfig;
import com.rbc.cloud.common.mybatis.MyBatisConfig;
import com.rbc.cloud.common.properties.JwtProperties;
import com.rbc.cloud.common.properties.SsyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * @author DingYihang
 */
@SpringBootApplication
@EnableFeignClients
@Import({MyBatisConfig.class, FeignConfig.class })
@EnableConfigurationProperties({SsyProperties.class, JwtProperties.class})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}