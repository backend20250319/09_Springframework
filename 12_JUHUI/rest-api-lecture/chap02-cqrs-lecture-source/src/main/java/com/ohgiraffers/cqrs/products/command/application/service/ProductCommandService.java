package com.ohgiraffers.cqrs.products.command.application.service;

import com.ohgiraffers.cqrs.common.service.FileStorageService;
import com.ohgiraffers.cqrs.products.command.application.dto.request.ProductCreateRequest;
import com.ohgiraffers.cqrs.products.command.domain.aggregate.Product;
import com.ohgiraffers.cqrs.products.command.domain.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ProductCommandService {

    private final ProductRepository productRepository;
    private final FileStorageService fileStorageService;
    private final ModelMapper modelMapper;

    @Value("${imag.image-url}")
    private String IMAGE_URL;

    /***
     * 상품등록
     * @param productCreateRequest
     * @param productImg
     * @return
     */
    public Long createProduct(ProductCreateRequest productCreateRequest, MultipartFile productImg) {
        // 1. File 저장 => FileStorageService 를 이용
        String replaceFileName = fileStorageService.storeFile(productImg);

        // 2. DTO -> Entity 변환
        Product newProect = modelMapper.map(productCreateRequest, Product.class);
        newProect.changeProductImageUrl(IMAGE_URL + replaceFileName);

        // 3. productRepository entity save
        Product product = productRepository.save(newProect);

        return product.getProductCode();
    }
}
