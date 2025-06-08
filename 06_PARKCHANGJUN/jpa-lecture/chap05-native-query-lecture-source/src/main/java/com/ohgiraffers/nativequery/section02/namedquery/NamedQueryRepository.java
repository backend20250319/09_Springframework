package com.ohgiraffers.nativequery.section02.namedquery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NamedQueryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> selectByNativeQuery() {
        Query nativequery = entityManager.createNamedQuery("Category.menuCountOfCategory");
        return nativequery.getResultList();
    }
}
