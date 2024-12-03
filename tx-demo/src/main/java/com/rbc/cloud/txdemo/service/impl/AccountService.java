package com.rbc.cloud.txdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbc.cloud.txdemo.entity.Account;
import com.rbc.cloud.txdemo.mapper.AccountMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账户服务实现类，提供转账功能
 *
 * @author DingYihang
 */
@Service
@AllArgsConstructor
public class AccountService extends ServiceImpl<AccountMapper, Account> {

    private final AccountMapper accountMapper;

    /**
     * 转账功能
     *
     * @param fromId 转出账户ID
     * @param toId 转入账户ID
     * @param amount 转账金额
     */
    @Transactional
    public void transferMoney(Long fromId, Long toId, Double amount) {
        // 查询转出账户和转入账户
        Account fromAccount = accountMapper.selectById(fromId);
        Account toAccount = accountMapper.selectById(toId);

        // 检查转出账户余额是否足够
        if (fromAccount == null) {
            throw new RuntimeException("转出账户不存在");
        }
        if (toAccount == null) {
            throw new RuntimeException("转入账户不存在");
        }

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("余额不足");
        }

        // 扣减转出账户金额
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        accountMapper.updateById(fromAccount);

        // 增加转入账户金额
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountMapper.updateById(toAccount);

        //模拟单笔转账金额限制
        if(amount > 1000){
            throw new RuntimeException("单笔转账金额不能超过1000,触发事务回滚！");
        }
    }
}
