package com.ohgiraffers.cqrs.products.query.controller;

import com.ohgiraffers.cqrs.common.dto.ApiResponse;
import com.ohgiraffers.cqrs.products.query.dto.request.ProductSearchRequest;
import com.ohgiraffers.cqrs.products.query.dto.response.ProductDetailResponse;
import com.ohgiraffers.cqrs.products.query.dto.response.ProductListResponse;
import com.ohgiraffers.cqrs.products.query.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductQueryController {
    // 생성자 주입을 위한 final 필드: 상품 조회 서비스
    private final ProductQueryService productQueryService;

    // 상품 상세 조회
    @GetMapping("/products/{productCode}")
    public ResponseEntity<ApiResponse<ProductDetailResponse>> getProduct(@PathVariable Long productCode) {
        ProductDetailResponse response = productQueryService.getProduct(productCode);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 상품 목록 조회
    @GetMapping("/products")
    public ResponseEntity<ApiResponse<ProductListResponse>> getProducts(
            ProductSearchRequest productSearchRequest
    ) {
        ProductListResponse response = productQueryService.getProducts(productSearchRequest); // productSearchRequest 삭제시 전체 조회
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
