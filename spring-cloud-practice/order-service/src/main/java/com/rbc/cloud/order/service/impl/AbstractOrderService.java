package com.rbc.cloud.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbc.cloud.api.pojo.dto.OrderDTO;
import com.rbc.cloud.api.pojo.dto.ProductDTO;
import com.rbc.cloud.api.pojo.query.OrderCreateQuery;
import com.rbc.cloud.common.properties.SsyProperties;
import com.rbc.cloud.order.entity.OrderDO;
import com.rbc.cloud.order.mapper.OrderMapper;
import com.rbc.cloud.order.mapping.OrderMapping;
import com.rbc.cloud.order.service.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 抽象产品服务
 *
 * @author moqi
 */
@Slf4j
public abstract class AbstractOrderService extends ServiceImpl<OrderMapper, OrderDO> implements OrderService {

    @Resource
    private SsyProperties ssyProperties;

    @Resource
    private OrderMapping orderMapping;

    @Override
    public OrderDTO createOrder(OrderCreateQuery orderCreateQuery) {
        log.info("调用商品服务查询商品信息");
        int productId = orderCreateQuery.getProductId();
        ProductDTO productDTO = queryProductInfo(productId);
        if (Objects.isNull(productDTO)) {
            throw new RuntimeException("商品不存在");
        }
        if (productDTO.getId() == -1) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setProductId(productId);
            orderDTO.setDesc("下单失败");
            return orderDTO;
        }
        // 构建订单
        OrderDO orderDO = buildOrder(productDTO, orderCreateQuery);
        // 保存订单
        this.save(orderDO);
        // 减库存
        this.deduct(orderCreateQuery);
        // 映射返回订单
        OrderDTO orderDTO = orderMapping.convertTo(orderDO);
        orderDTO.setSite(ssyProperties.getSite());
        orderDTO.setDesc(productDTO.getProductDesc());

/*        if (orderDTO.getId() % 3 == 0){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }*/
//
//        if (orderDTO.getId() % 2 == 0){
//            throw new RuntimeException("下单失败");
//
//        }

        return orderDTO;
    }

    /**
     * 获取产品信息（由不同服务继承实现）
     *
     * @param productId 产品id
     * @return ProductDTO
     */
    protected abstract ProductDTO queryProductInfo(int productId);

    /**
     * 减库存
     *
     * @param orderCreateQuery 查询参数
     */
    protected abstract void deduct(OrderCreateQuery orderCreateQuery);


    /**
     * 构建订单
     *
     * @param productDTO       产品dto
     * @param orderCreateQuery 订单创建参数
     * @return OrderDO
     */
    private OrderDO buildOrder(ProductDTO productDTO, OrderCreateQuery orderCreateQuery) {
        OrderDO orderDO = new OrderDO();
        orderDO.setUid(1);
        // 从配置中心读取
        orderDO.setUsername(ssyProperties.getUsername());
//        orderDO.setUsername(ssyProperties.getUsername() + ":" + ssyProperties.getSecretKey());
        orderDO.setProductId(productDTO.getId());
        orderDO.setProductName(productDTO.getProductName());
        orderDO.setPrice(productDTO.getPrice());
        orderDO.setCount(orderCreateQuery.getCount());
        orderDO.setStatus(0);
        return orderDO;
    }
}