package com.rbc.cloud.txdemo.controller;

import com.rbc.cloud.txdemo.service.impl.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DingYihang
 */
@AllArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long from,@RequestParam Long  to,@RequestParam double amount) {
        try {
            accountService.transferMoney(from, to, amount);
            return "转账成功";
        } catch (Exception e) {
            return  e.getMessage()+"转账失败";
        }
    }
}
