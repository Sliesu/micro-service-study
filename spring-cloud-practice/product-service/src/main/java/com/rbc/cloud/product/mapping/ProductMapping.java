package com.rbc.cloud.product.mapping;


import com.rbc.cloud.api.pojo.dto.ProductDTO;
import com.rbc.cloud.common.handler.BaseMapping;
import com.rbc.cloud.product.entity.ProductDO;
import org.mapstruct.Mapper;


/**
 * @author mqxu
 * @date 2024/9/20
 * @description ProductMapping
 **/
@Mapper(componentModel = "spring")
public interface ProductMapping extends BaseMapping<ProductDO, ProductDTO> {

}