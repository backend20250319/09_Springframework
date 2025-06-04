package com.ohgiraffers.jpql.section03.projection;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_menu")
public class EmbeddedMenu {

    private int menuCode;
    private String menuName;
                                                             f                                                                                                                                                                                                                                                                                                              ff
    @Embedded
    private MenuInfo menuInfo;

    private int categoryCode;
    private String orderableStatus;
}
