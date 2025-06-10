package com.jsw.cqrs.products.command.domain.aggregate;

public enum ProductStatus {

    USABLE,         // 주문 가능
    DISABLED,       // 주문 불가
    DELETED         // 삭제
}
