package com.rbc.cloud.product;

import com.rbc.cloud.common.handler.FeignConfig;
import com.rbc.cloud.common.handler.SentinelConfig;
import com.rbc.cloud.common.mybatis.MyBatisConfig;
import com.rbc.cloud.common.properties.SsyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;


/**
 * @author mqxu
 * @date 2024/9/11
 * @description ProductApplication
 **/
@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({SsyProperties.class})
@Import({MyBatisConfig.class, FeignConfig.class, SentinelConfig.class})
@MapperScan(basePackages = {"com.rbc.cloud.product.mapper"})
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}