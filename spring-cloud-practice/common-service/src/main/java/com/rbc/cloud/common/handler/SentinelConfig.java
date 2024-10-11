package com.rbc.cloud.common.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SentinelConfig
 *
 * @author dingyihang
 * @date 2024/10/11
 * @description Sentinel 配置类，定义流量控制异常处理器
 */
@Configuration
public class SentinelConfig {

    /**
     * 定义 BlockExceptionHandler Bean
     *
     * @return BlockExceptionHandler 实例
     */
    @Bean
    public BlockExceptionHandler blockExceptionHandler() {
        // 使用自定义的异常处理器
        return new SentinelExceptionHandler();
    }

    @Bean
    public RequestOriginParser requestOriginParser() {
        return new SentinelRequestOriginParser();
    }
}
