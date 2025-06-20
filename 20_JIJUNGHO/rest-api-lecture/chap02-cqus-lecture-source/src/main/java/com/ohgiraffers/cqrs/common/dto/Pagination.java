package com.ohgiraffers.cqrs.common.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Pagination {

    private final int currentPages;
    private final int totalPages;
    private final long totalItems;
}
