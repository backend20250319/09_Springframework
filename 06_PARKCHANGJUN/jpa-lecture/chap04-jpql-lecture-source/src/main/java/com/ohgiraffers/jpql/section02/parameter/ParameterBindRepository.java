package com.ohgiraffers.jpql.section02.parameter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParameterBindRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> selectMenuByBindingName(String menuName) {
        String jpql = "SELECT m FROM Section02Menu m WHERE m.menuName = :menuName";
        // getResultList : TypeQuery 타입
        return entityManager.createQuery(jpql, Menu.class)
                            .setParameter("menuName", menuName)
                            .getResultList();
    }

    public List<Menu> selectMenuByBindingPosition(String menuName) {
        String jpql = "SELECT m FROM Section02Menu m WHERE m.menuName = ?1";
        return entityManager.createQuery(jpql, Menu.class)
                            .setParameter(1, menuName)
                            .getResultList();
    }
}
