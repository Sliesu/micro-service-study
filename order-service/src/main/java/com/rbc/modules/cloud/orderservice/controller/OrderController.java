package com.rbc.modules.cloud.orderservice.controller;

import com.rbc.modules.cloud.orderservice.common.utils.OrderStatus;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



/**
 * @author DingYihang
 */
/**
 * @author moqi
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/order")
    public String createOrder(@RequestParam String orderId,
                              @RequestParam String username,
                              @RequestParam String productId,
                              @RequestParam OrderStatus status) {
        // 调用 user-service 获取用户信息
        String userServiceUrl = "http://localhost:8081/user?username=" + username;
        String userInfo = restTemplate.getForObject(userServiceUrl, String.class);

        // 调用 product-service 获取产品信息
        String productServiceUrl = "http://localhost:8083/product?productId=" + productId;
        String productInfo = restTemplate.getForObject(productServiceUrl, String.class);

        // 使用 switch 表达式处理订单状态
        String orderStatusMessage = switch (status) {
            case PENDING -> "您的订单正在等待处理。";
            case PROCESSING -> "您的订单正在处理中。";
            case COMPLETED -> "您的订单已完成。";
            case CANCELLED -> "您的订单已取消。";
        };

        // 返回完整的订单信息
        return "订单ID: " + orderId + "，下单人: " + userInfo + "，商品信息: " + productInfo + "，订单状态: " + status + "。" + orderStatusMessage;
    }
}
