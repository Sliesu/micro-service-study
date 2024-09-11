package com.rbc.cloud.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/{userId}")
    public List<String> getUserOrders(@PathVariable String userId) {
        // 模拟返回订单列表
        List<String> list = new ArrayList<>();
        list.add(userId + ":Order-001");
        list.add(userId + ":Order-002");
        list.add(userId + ":Order-003");
        return list;
    }
}