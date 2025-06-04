package com.ohgiraffers.jpql.section03.projection;

public class CategoryInfo {

    private int categoryCode;
    private String categoryName;

    public CategoryInfo(String categoryName, int categoryCode) {
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "CategoryInfo{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
