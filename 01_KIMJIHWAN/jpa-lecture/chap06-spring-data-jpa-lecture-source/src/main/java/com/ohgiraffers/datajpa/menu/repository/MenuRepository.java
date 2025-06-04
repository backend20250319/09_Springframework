package com.ohgiraffers.datajpa.menu.repository;

import com.ohgiraffers.datajpa.menu.entity.Menu;    // Entity의 Menu를 import
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> { // JpaRepository를 상속받아(extends) 사용
}
