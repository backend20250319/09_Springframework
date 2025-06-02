package com.ohgiraffers.associationmapping.section02.ontomany;

import com.ohgiraffers.associationmapping.section01.manytoone.Category;
import com.ohgiraffers.associationmapping.section01.manytoone.CategoryDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OneTwoManyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Category find(int categoryCode) {
        return entityManager.find(Category.class, categoryCode);
    }

    public void regist(Category category){
        entityManager.persist(category);
    }

    public Category findCategory(int categoryCode) {
        Category category = OneTwoManyRepository
    }
}
