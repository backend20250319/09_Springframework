package com.ohgiraffers.cqrs.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                /* 필드명이 완전히 동일해야 변환(엄격모드) */
                .setMatchingStrategy(MatchingStrategies.STRICT)
                /* Setter 메소드 미사용시 ModelMapper가 private 필드에 접근 */
                .setFieldAccessLevel(
                        org.modelmapper.config.Configuration.AccessLevel.PRIVATE
                )
                .setFieldMatchingEnabled(true);
        return  modelMapper;
    }
}
