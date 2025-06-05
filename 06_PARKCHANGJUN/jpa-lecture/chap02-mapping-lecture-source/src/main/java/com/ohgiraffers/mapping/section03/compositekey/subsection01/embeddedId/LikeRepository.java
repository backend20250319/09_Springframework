package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedId;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository // bean에 등록
public class LikeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Like like) {
        entityManager.persist(like);
    }
}
