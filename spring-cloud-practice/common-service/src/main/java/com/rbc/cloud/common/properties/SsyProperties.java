package com.rbc.cloud.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mqxu
 * @date 2024/9/19
 * @description Ssy 参数
 **/
@Data
@ConfigurationProperties(prefix = "ssy")
public class SsyProperties {
    /**
     * 用户名
     */
    private String username;

    /**
     * 网站
     */
    private String site;

    /**
     * 密钥
     */
    private String secretKey;
}
