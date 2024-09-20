package com.rbc.cloud.common.handler;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description Feign 请求拦截器
 **/
@RequiredArgsConstructor
public class FeignRequestInterceptor implements RequestInterceptor {

    private final HttpServletRequest request;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 转发用户信息
        String uid = request.getHeader("uid");
        String username = request.getHeader("username");
        requestTemplate.header("uid", uid);
        requestTemplate.header("username", username);
    }

}