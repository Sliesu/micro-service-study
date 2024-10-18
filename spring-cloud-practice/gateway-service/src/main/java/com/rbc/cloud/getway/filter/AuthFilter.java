package com.rbc.cloud.getway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局认证过滤器
 */
@Slf4j
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        // 使用 Apache Commons Lang 的 StringUtils
        if (org.apache.commons.lang3.StringUtils.isBlank(token)) {
            log.error("网关请求认证失败");
            throw new RuntimeException("非法请求");
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 优先级，数字越小优先级越高
        return 0;
    }
}
