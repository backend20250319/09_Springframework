package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "menu_and_category")
@Table(name = "tbl_menu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Menu {

    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;

    /*
    * 영속성 전이 : 특정 엔터티를 영속화(영속성 컨텍스트에서 관리)할 때 연관된 엔터티도
    * 함께 영속화 한다는 의미이다.
    * fetch type default 는 EAGER 로 되어 있으며 필요한 경우 LAZY 로 명시해서 지연 로딩을 할 수 있다.
    * */
    @ManyToOne(cascade = CascadeType.PERSIST)//fetch = FetchType.LAZY) // EAGER 이른 초기화, singleton에서도 썼었음.
    @JoinColumn(name = "categoryCode") //"Fk"에 해당하는 컬럼명 써야함.
    private Category category;

    private String orderableStatus;
}
