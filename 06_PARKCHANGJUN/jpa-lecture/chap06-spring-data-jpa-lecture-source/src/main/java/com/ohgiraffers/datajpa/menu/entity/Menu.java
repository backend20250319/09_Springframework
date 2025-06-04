package com.ohgiraffers.datajpa.menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tbl_menu")
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // menu 엔터티에 있는 pk는 mysql 기준이고 Auto_Increment를 사용할 수 있다.
    private int menuCode;

    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public void modifyMenuName(String menuName) {
        this.menuName = menuName;
    }
}
