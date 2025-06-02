package com.ohgiraffers.associationmapping.section03.bidirection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

public class BiDirectionRepository {
    public Category findCategory(int categoryCode) {
    }

    public Menu findMenu(int menuCode) {
    }

    public void saveMenu(Menu menu) {
    }

    public void saveCategory(Category category) {
    }

    @Repository
    public class BiDirectionRepository {

        @PersistenceContext
        private EntityManager entityManager;

        public Menu findMenu(int menuCode) {
            return entityManager.find(Menu.class, menuCode);
        }

        public Category findCategory(int categoryCode) {
            return entityManager.find(Category.class, categoryCode);
        }

        public void saveMenu(Menu menu) {
            entityManager.persist(menu);
        }

        public void saveCategory(Category category) {
            entityManager.persist(category);
        }
    }
}
