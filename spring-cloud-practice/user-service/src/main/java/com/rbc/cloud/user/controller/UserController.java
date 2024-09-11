package com.rbc.cloud.user.controller;

import com.rbc.cloud.user.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DingYihang
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/{userId}/orders")
    public List<String> getUserOrders(@PathVariable String userId) {
        return userService.getUserOrders(userId);
    }
}