package com.rbc.cloud.api.pojo.dto;

import lombok.Data;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description 产品 DTO
 **/
@Data
public class ProductDTO {
    /**
     * ID
     */
    private Integer id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品描述
     */
    private String productDesc;

    /**
     * 价格
     */
    private Double price;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 规格
     */
    private String specification;
}
