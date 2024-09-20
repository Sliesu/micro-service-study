package com.rbc.cloud.api.pojo.dto;

import lombok.Data;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description 订单 DTO
 **/
@Data
public class OrderDTO {
    /**
     * ID
     */
    private Integer id;

    /**
     * 用户 ID
     */
    private Integer uid;

    /**
     * 产品 ID
     */
    private Integer productId;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 产品名称
     */
    private String productName;
    /**
     * 价格
     */
    private Double price;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 网站
     */
    private String site;

    /**
     * 下单描述
     */
    private String desc;
}
