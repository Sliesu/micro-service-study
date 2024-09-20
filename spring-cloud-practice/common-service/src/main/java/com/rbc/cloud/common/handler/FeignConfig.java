package com.rbc.cloud.common.handler;

import org.springframework.context.annotation.Import;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description FeignConfig
 **/
@Import({FeignRequestInterceptor.class})
public class FeignConfig {

}