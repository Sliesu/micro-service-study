package com.rbc.cloud.nacosdemoapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DingYihang
 */
@RestController
@RefreshScope
public class DemoController {

    @Value("${example.property}")
    private String property;

    @GetMapping("/demo")
    public String demo() {
        return property;
    }
}
