package com.rbc.cloud.order.service.feign;


import com.rbc.cloud.api.facede.ProductFacade;
import com.rbc.cloud.common.constants.ServiceConsts;
import org.springframework.cloud.openfeign.FeignClient;


/**
 * @author mqxu
 * @date 2024/9/20
 * @description ProductService
 **/
@FeignClient(value = ServiceConsts.PRODUCT_SERVICE, fallbackFactory = ProductServiceFallBackFactory.class)
public interface ProductService extends ProductFacade {

}