package com.ohgiraffers.jpql.section03.projection;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable // embedding 한다? 어딘가에 추가하는 내용,MenuInfo 클래스가 어떤 특정 클래스의 필드에 추가될 수 있다. 그런 용도로 사용될 거다.
public class MenuInfo {

    private int menuCode;

    @Embedded
    private MenuInfo menuInfo;
//    private String menuName;
//    private int menuPrice;

    private int categoryCode;
    private String orderableStatus;
}
