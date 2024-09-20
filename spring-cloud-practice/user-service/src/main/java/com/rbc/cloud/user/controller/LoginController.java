package com.rbc.cloud.user.controller;

import com.rbc.cloud.api.facede.LoginFacade;
import com.rbc.cloud.api.pojo.query.LoginQuery;
import com.rbc.cloud.common.pojo.ResponseData;
import com.rbc.cloud.common.properties.JwtProperties;
import com.rbc.cloud.common.util.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LoginController implements LoginFacade {

    private final JwtProperties jwtProperties;
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Override
    public ResponseData<String> login(@RequestBody LoginQuery loginQuery) {
        log.info("用户开始登录: [{}]", loginQuery);

        // 查询数据库检查用户名密码〔略〕
        // 假设验证通过后继续执行

        // 从配置中心获取安全密钥
        String secretKey = jwtProperties.getSecretKey();

        // JWT Token附加的用户信息
        Map<String, Object> claims = new HashMap<>();
        claims.put("uid", "10001");
        claims.put("username", loginQuery.getUsername());

        // JWT Token过期时间
        Date expireDate = DateUtils.addHours(new Date(), 24);

        // 生成 Token并返回
        String token = JwtUtils.createToken(secretKey, null, claims, expireDate);
        if (StringUtils.isNotBlank(token)) {
            return ResponseData.succeed(token);
        } else {
            return ResponseData.failed();
        }
    }
}
