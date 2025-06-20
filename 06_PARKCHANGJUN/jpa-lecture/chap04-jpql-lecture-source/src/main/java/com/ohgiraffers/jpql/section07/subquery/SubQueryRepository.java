package com.ohgiraffers.jpql.section07.subquery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubQueryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> selectWithSubQuery(String categoryName) {
        String jpql = "SELECT m FROM Section07Menu m WHERE m.categoryCode = (" +
                "SELECT c.categoryCode FROM Section07Category c " +
                "WHERE c.categoryName = :categoryName)";
        // :categoryName 대신 ?1 써도 가능하다.

        return entityManager.createQuery(jpql, Menu.class)
                .setParameter("categoryName", categoryName)
                .getResultList();
    }
}
