package com.ohgiraffers.jpql.section01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleJPQLRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public String selectSingleMenuByTypedQuery(){
        String jpql = 
    }
}
