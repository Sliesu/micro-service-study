package com.rbc.cloud.api.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description 减库存请求参数
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockDeductQuery {

    /**
     * 产品ID
     */
    private Integer productId;

    /**
     * 数量
     */
    private Integer count;

}