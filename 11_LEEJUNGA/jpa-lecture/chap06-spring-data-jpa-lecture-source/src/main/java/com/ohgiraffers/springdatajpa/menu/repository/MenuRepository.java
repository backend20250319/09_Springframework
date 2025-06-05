package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    // 전달받은 가격을 초과하는 메뉴 목록 조회
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice);

    // 전달받은 가격을 초과하는 메뉴 목록 조회 + 가격 오름차순 조회
    List<Menu> findByMenuPriceGreaterThanOrderByMenuPriceAsc(Integer menuPrice);

    // 전달 받은 가격을 초과하는 메뉴 목록 조회 + 전달 받은 정렬 기준
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice, Sort sort);
}
