package com.ohgiraffers.cqrs.products.query.service;

import com.ohgiraffers.cqrs.exception.BusinessException;
import com.ohgiraffers.cqrs.exception.ErrorCode;
import com.ohgiraffers.cqrs.products.query.dto.response.ProductDetailResponse;
import com.ohgiraffers.cqrs.products.query.dto.response.ProductDto;
import com.ohgiraffers.cqrs.products.query.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductQueryService {

    private final ProductMapper productMapper;

    /***
     * 상품 상세 조회
     * @param productCode
     * @return
     */
    public ProductDetailResponse getProduct(Long productCode) {
        ProductDto product = Optional.ofNullable(
                productMapper.selectProductByCode(productCode)
        ).orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));

        return ProductDetailResponse.builder().product(product).build();
    }


}
