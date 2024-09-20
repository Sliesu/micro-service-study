package com.rbc.cloud.api.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mqxu
 * @date 2024/9/19
 * @description 登录请求参数
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginQuery {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    // .. 更多可自行自定义


}