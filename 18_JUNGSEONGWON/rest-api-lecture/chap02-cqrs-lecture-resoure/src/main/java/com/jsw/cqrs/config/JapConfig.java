package com.jsw.cqrs.config;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableJpaAuditing // 어노테이션을 활용해서 자동으로 값을 등록 할 수 있다.
public class JapConfig {
}
