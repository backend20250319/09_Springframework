package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Section01Category")
@Table(name="tbl_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Category {

    @Id
    // @Column : yml파일에 써준 카멜케이스를 해당 부분을
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;
}
