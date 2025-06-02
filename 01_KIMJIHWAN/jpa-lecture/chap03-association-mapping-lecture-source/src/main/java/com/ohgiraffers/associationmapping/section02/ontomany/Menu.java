package com.ohgiraffers.associationmapping.section02.ontomany;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Menu {

    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    public String orderableStatus;

}
