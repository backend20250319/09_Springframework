package com.ohgiraffers.cqrs.products.command.domain.repository;

import com.ohgiraffers.cqrs.products.command.domain.aggregate.Product;

public interface ProductRepository {

    Product save(Product newProduct);


}
