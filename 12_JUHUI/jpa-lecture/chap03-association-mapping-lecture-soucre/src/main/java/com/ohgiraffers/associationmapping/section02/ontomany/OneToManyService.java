package com.ohgiraffers.associationmapping.section02.ontomany;

import org.springframework.stereotype.Service;

@Service
public class OneToManyService {

    private OneTwoManyRepository oneTwoManyRepository;

    public OneToManyService(OneTwoManyRepository oneTwoManyRepository) {
        this.oneTwoManyRepository = oneTwoManyRepository;
    }
}
