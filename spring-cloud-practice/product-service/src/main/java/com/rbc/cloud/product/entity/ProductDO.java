package com.rbc.cloud.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description ProductDO
 **/
@TableName("t_product")
@Data
public class ProductDO {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String productName;

    private String productDesc;

    private Double price;

    private Integer count;

    private String specification;

}