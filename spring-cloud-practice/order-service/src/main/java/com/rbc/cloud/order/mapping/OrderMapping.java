package com.rbc.cloud.order.mapping;

import com.rbc.cloud.api.pojo.dto.OrderDTO;
import com.rbc.cloud.common.constants.DateConsts;
import com.rbc.cloud.common.handler.BaseMapping;
import com.rbc.cloud.order.entity.OrderDO;
import org.mapstruct.Mapper;

import java.time.format.DateTimeFormatter;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description OrderMapping
 **/
@Mapper(componentModel = "spring")
public interface OrderMapping extends BaseMapping<OrderDO, OrderDTO> {

    @Override
    default void afterConvertTo(OrderDO src, OrderDTO dest) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DateConsts.YYYY_MM_DD_HH_MM_SS);
        dest.setCreateTime(src.getCreateTime().format(dateTimeFormatter));
        dest.setUpdateTime(src.getUpdateTime().format(dateTimeFormatter));
    }

}