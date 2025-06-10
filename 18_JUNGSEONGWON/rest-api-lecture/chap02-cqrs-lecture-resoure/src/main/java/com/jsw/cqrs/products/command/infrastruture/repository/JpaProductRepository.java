package com.jsw.cqrs.products.command.infrastruture.repository;

import com.jsw.cqrs.products.command.domain.aggregate.Product;
import com.jsw.cqrs.products.command.domain.respository.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends ProductRepository, JpaRepository<Product, Long> {
}
