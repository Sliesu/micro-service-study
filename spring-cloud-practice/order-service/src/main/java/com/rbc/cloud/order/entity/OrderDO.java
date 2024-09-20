package com.rbc.cloud.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description OrderDO
 **/
@TableName("t_order")
@Data
public class OrderDO {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    private Integer uid;

    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    private Integer productId;

    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String username;

    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String productName;

    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    private Double price;

    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    private Integer count;

    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
