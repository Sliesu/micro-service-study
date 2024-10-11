package com.rbc.cloud.common.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


/**
 * @author DingYihang
 */
@Slf4j
@Component
public class SentinelExceptionHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        String msg = "未知异常";
        int code = HttpStatus.INTERNAL_SERVER_ERROR.value();

        // 日志记录 Sentinel 异常
        log.error("Sentinel异常:", e);

        // 根据不同的异常类型设置错误信息和状态码
        if (e instanceof FlowException) {
            msg = "请求被限流了";
        } else if (e instanceof ParamFlowException) {
            msg = "请求被热点参数限流了";
        } else if (e instanceof DegradeException) {
            msg = "请求被降级了";
        } else if (e instanceof AuthorityException) {
            msg = "没有权限访问";
        } else if (e instanceof SystemBlockException) {
            msg = "限流系统异常";
        }

        // 设置响应内容类型和状态码
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(code);

        // 返回 JSON 格式的错误信息
        String jsonResponse = String.format("{\"msg\":\"%s\",\"code\":%d}", msg, code);
        response.getWriter().println(jsonResponse);
    }
}
