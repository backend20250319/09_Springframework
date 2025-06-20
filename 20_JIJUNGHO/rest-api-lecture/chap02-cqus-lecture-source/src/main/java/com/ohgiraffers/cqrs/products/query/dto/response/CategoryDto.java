package com.ohgiraffers.cqrs.products.query.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    private long categoryCode;
    private String categoryName;
}
