package com.rbc.cloud.getway.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * date: 2024/10/18
 * description: 全局异常处理器
 * @author DingYihang
 */
@Slf4j
@Component
public class GlobalErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        // 获取错误信息
        Throwable error = super.getError(request);
        log.error("网关处理异常", error);

        // 构建错误响应
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("code", HttpStatus.BAD_REQUEST.value());
        errorMap.put("msg", error.getMessage());

        return errorMap;
    }
}
