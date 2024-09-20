package com.rbc.cloud.order.service.impl;

import com.rbc.cloud.api.pojo.dto.ProductDTO;
import com.rbc.cloud.api.pojo.query.OrderCreateQuery;
import com.rbc.cloud.common.constants.ServiceConsts;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * @author mqxu
 * @date 2024/9/20
 * @description OrderServiceImpl
 **/
@Slf4j
@Service
public class OrderServiceImpl extends AbstractOrderService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    private static final String QUERY_PRODUCT_INFO_URL = "http://%s:%s/product/%d";


    @Override
    protected ProductDTO queryProductInfo(int productId) {
        // 获取任意产品微服务实例
        ServiceInstance serviceInstance =
                discoveryClient.getInstances(ServiceConsts.PRODUCT_SERVICE)
                        .stream().findAny().get();
        // 获取产品信息请求地址
        String url = String.format(QUERY_PRODUCT_INFO_URL, serviceInstance.getHost(),
                serviceInstance.getPort(), productId);
        log.info("调用产品微服务获取产品信息地址:{}", url);
        return restTemplate.getForObject(url, ProductDTO.class);
    }

    @Override
    protected void deduct(OrderCreateQuery orderCreateQuery) {
        // 在 Feign 实现类中实现了
    }
}