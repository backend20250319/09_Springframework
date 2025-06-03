package com.ohgiraffers.jpql.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleJPQLRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Object selectSingleMenuByTypedQuery(){
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = = 8";
//        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        Query query = entityManager.createQuery(jpql);
        Object resultMenuName = query.getSingleResult();
        return resultMenuName;

    }
}
