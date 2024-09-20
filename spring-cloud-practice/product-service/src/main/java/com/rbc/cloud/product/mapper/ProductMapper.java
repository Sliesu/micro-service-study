package com.rbc.cloud.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbc.cloud.product.entity.ProductDO;
import org.apache.ibatis.annotations.Param;


/**
 * @author mqxu
 * @date 2024/9/20
 * @description ProductMapper
 **/
public interface ProductMapper extends BaseMapper<ProductDO> {

    /**
     * 减对应产品库存
     *
     * @param productId 产品id
     * @param count     数量
     * @return int
     */
    int deduct(@Param("id") Integer productId, @Param("count") Integer count);

}