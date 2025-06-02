package com.ohgiraffers.associationmapping.section03.bidirection;

import com.ohgiraffers.associationmapping.section01.manytoone.Menu;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Category {
    @Entity(name = "bidirection_category")
    @Table(name = "tbl_category")
    public class Category {

        @Id
        private int categoryCode;

        private String categoryName;

        private Integer refCategoryCode;

        @OneToMany(mappedBy="category")
        private List<Menu> menuList;

        protected Category() {}

        public Category(
                int categoryCode, String categoryName, Integer refCategoryCode
        ) {
            this.categoryCode = categoryCode;
            this.categoryName = categoryName;
            this.refCategoryCode = refCategoryCode;
        }

        public Category(
                int categoryCode, String categoryName,
                Integer refCategoryCode, List<Menu> menuList
        ) {
            this.categoryCode = categoryCode;
            this.categoryName = categoryName;
            this.refCategoryCode = refCategoryCode;
            this.menuList = menuList;
        }

        public int getCategoryCode() {
            return categoryCode;
        }
        public void setCategoryCode(int categoryCode) {
            this.categoryCode = categoryCode;
        }
        public String getCategoryName() {
            return categoryName;
        }
        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }
        public Integer getRefCategoryCode() {
            return refCategoryCode;
        }
        public void setRefCategoryCode(Integer refCategoryCode) {
            this.refCategoryCode = refCategoryCode;
        }
        public List<Menu> getMenuList() {
            return menuList;
        }
        public void setMenuList(List<Menu> menuList) {
            this.menuList = menuList;
        }
        @Override
        public String toString() {
            return "Category [categoryCode=" + categoryCode +
                    ", categoryName=" + categoryName +
                    ", refCategoryCode=" + refCategoryCode + "]";
        }

    }
}
