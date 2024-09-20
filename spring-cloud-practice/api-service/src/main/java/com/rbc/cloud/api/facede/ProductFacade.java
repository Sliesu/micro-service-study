package com.rbc.cloud.api.facede;

import com.rbc.cloud.api.pojo.dto.ProductDTO;
import com.rbc.cloud.api.pojo.query.ProductStockDeductQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description 产品服务接口
 **/
public interface ProductFacade {

    @GetMapping("/product/{id}")
    ProductDTO queryProductInfo(@PathVariable("id") Integer productId);

    @PostMapping("/product/stock/deduct")
    boolean deductStock(@RequestBody ProductStockDeductQuery productStockDeductQuery);

}