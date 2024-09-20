package com.rbc.cloud.api.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description 优惠券 DTO
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponDTO {
    private Integer id;

    private String code;

    private Integer money;

    private Integer orderId;

    private String desc;

}
