package com.ohgiraffers.cqrs.products.command.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@RequiredArgsConstructor
@ToString
public class ProductCreateRequest {

    @NotBlank
    private final String productName;
    @Min(value = 1)
    private final Long productPrice;
    @NotBlank
    private final String productDescription;
    @Min(value = 1)
    private final Long categoryCode;
    @Min(value = 1)
    private final Long productStock;

}
