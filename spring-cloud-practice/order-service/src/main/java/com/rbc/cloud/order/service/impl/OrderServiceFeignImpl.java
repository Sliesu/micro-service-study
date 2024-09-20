package com.rbc.cloud.order.service.impl;


import com.rbc.cloud.api.pojo.dto.ProductDTO;
import com.rbc.cloud.api.pojo.query.OrderCreateQuery;
import com.rbc.cloud.api.pojo.query.ProductStockDeductQuery;

import com.rbc.cloud.order.service.feign.ProductService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description OrderServiceFeignImpl
 **/
@Slf4j
@RefreshScope
@Primary
@Service
public class OrderServiceFeignImpl extends AbstractOrderService {

    @Resource
    private ProductService productService;

    @Override
    protected ProductDTO queryProductInfo(int productId) {
        log.info("调用 Open Feign 产品微服务获取产品信息");
        return productService.queryProductInfo(productId);
    }

    @Override
    protected void deduct(OrderCreateQuery orderCreateQuery) {
        ProductStockDeductQuery productStockDeductQuery = new ProductStockDeductQuery(orderCreateQuery.getProductId(), orderCreateQuery.getCount());
        boolean deductResult = productService.deductStock(productStockDeductQuery);
        if (!deductResult) {
            throw new RuntimeException("减库存失败");
        }
        log.info("减库存结果：{}", "成功");
    }
}