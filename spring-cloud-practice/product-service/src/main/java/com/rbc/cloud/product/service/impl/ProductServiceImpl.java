package com.rbc.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbc.cloud.api.pojo.query.ProductStockDeductQuery;
import com.rbc.cloud.product.entity.ProductDO;
import com.rbc.cloud.product.mapper.ProductMapper;
import com.rbc.cloud.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author mqxu
 * @date 2024/9/20
 * @description ProductServiceImpl
 **/
@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductDO> implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public int deduct(@RequestBody ProductStockDeductQuery productStockDeductQuery) {
        return productMapper.deduct(productStockDeductQuery.getProductId(),
                productStockDeductQuery.getCount());
    }

}