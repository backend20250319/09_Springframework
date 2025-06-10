package com.ohgiraffers.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ohgiraffers.restapi")
public class Chap01RestApiLectureSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap01RestApiLectureSourceApplication.class, args);
    }

}
