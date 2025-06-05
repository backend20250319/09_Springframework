package com.ohgiraffers.jpql.section06.join;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JoinRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // 메뉴 하나의 카테고리 정보를 가져올 수 있다.
    // private Category category; 를 작성했기 때문
    public List<Menu> selectByInnerJoin() {

        // JPQL에서는 on을 사용하지 않아도 전체 조인이 가능하다.
        String jpql = "SELECT m FROM Section06Menu m JOIN m.category c";
        return entityManager.createQuery(jpql, Menu.class)
                            .getResultList();
    }

    public List<Menu> selectByFetchJoin() {
        // fetch JPQL에서 성능 최적화를 위해 사용 하는 기능으로
        // 연관 엔터티나 컬렉션을 한 번에 조회한다.
        String jpql = "SELECT m FROM Section06Menu m JOIN FETCH m.category c";
        return entityManager.createQuery(jpql, Menu.class)
                            .getResultList();
    }

    public List<Object[]> selectByOuterJoin() {
        String jpql = "SELECT m.menuName, c.categoryName FROM Section06Menu m RIGHT JOIN m.category c";
        return entityManager.createQuery(jpql).getResultList();
    }

    public List<Object[]> selectByCollectionJoin() {
        String jpql = "SELECT c.categoryName, m.menuName FROM Section06Category c LEFT JOIN c.meunList m";
        return entityManager.createQuery(jpql).getResultList();
    }

    public List<Object[]> selectByThetaJoin() {
        String jpql = "SELECT c.categoryCode, m.menuName FROM Section06Category c, Section06Menu m";
        return entityManager.createQuery(jpql).getResultList();
    }

}
