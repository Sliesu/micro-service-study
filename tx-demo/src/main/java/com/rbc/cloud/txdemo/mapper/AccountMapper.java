package com.rbc.cloud.txdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbc.cloud.txdemo.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DingYihang
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
