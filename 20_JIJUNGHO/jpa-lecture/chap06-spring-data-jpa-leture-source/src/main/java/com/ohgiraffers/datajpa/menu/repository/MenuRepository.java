package com.ohgiraffers.datajpa.menu.repository;

import com.ohgiraffers.datajpa.menu.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    // 전달받은 가격을 초과하는 메뉴 목록 조회
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice);

    List<Menu> findByMenuPriceGreaterThanOrderByMenuPrice(Integer menuPrice);

    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice, Sort sort);
}
