package com.ohgiraffers.jpql.section06.join;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity(name = "Section06Category")
@Table(name = "tbl_category")
public class Category {

    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

    @OneToMany(mappedBy = "category") // 단방향은 오류남.
    private List<Menu> menuList; // 하나의 카테고리 안에는 여러 개의 메뉴가 있을거다.

}
