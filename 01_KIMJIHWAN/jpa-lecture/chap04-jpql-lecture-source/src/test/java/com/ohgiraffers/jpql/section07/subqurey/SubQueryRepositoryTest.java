package com.ohgiraffers.jpql.section07.subqurey;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubQueryRepositoryTest {

    @Autowired
    private SubQueryRepository subQueryRepository;

    @DisplayName("where절 서브쿼리 테스트")
    @Test
    void testSelectWithSubQuery() {
        String categoryName = "한식";
        List<Menu> menuList = subQueryRepository.selectWithSubQuery(categoryName);
        menuList.forEach(System.out::println);
    }
}