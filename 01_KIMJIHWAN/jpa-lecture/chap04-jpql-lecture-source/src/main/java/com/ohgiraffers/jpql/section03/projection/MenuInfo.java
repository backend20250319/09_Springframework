package com.ohgiraffers.jpql.section03.projection;

import jakarta.persistence.Embeddable;

@Embeddable // MenuInfo가 Menu에 추가 될 수도 있다.
public class MenuInfo {

    private String menuName;
    private int menuPrice;
}
