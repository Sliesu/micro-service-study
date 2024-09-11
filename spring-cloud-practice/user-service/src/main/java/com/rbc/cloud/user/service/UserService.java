package com.rbc.cloud.user.service;

import com.rbc.cloud.user.feign.OrderClient;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DingYihang
 */
@Service
public class UserService {
    @Resource
    private OrderClient orderClient;

    public List<String> getUserOrders(String userId) {
        return orderClient.getUserOrders(userId);
    }
}