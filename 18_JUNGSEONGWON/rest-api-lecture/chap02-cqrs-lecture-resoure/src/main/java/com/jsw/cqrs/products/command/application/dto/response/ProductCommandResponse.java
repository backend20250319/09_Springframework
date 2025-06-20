package com.jsw.cqrs.products.command.application.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductCommandResponse {

    private Long productCode;
}
