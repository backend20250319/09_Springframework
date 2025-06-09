package com.ohgiraffers.cqrs.products.query.mapper;

import com.ohgiraffers.cqrs.products.query.dto.response.ProductDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    
    // 상품 코드로 상품 하나 조회
    ProductDto selectProductByCode(Long productCode);
}
