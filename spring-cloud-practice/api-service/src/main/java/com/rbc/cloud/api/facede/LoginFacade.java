package com.rbc.cloud.api.facede;

import com.rbc.cloud.api.pojo.query.LoginQuery;
import com.rbc.cloud.common.pojo.ResponseData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * @author mqxu
 * @date 2024/9/19
 * @description 用户登录服务接口
 **/
public interface LoginFacade {

    @PostMapping("/login")
    ResponseData<String> login(@RequestBody LoginQuery loginQuery);

}