package com.rbc.cloud.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mqxu
 * @date 2024/9/19
 * @description 全局异常处理
 **/
@Configuration
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public Map<String, Object> exceptionHandler(Throwable ex) {
        log.error("全局异常处理：", ex);
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("msg", StringUtils.defaultIfBlank(ex.getMessage(), "系统异常"));
        return map;
    }

}