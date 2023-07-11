package com.group.libraryapp.config;

import org.springframework.context.annotation.Configuration;

// @Configuration + @Bean = 외부 라이브러리, 프레임워크에서 만든 클래스를 등록할 때
// @Service, @Repository = 개발자가 직접 만든 클래스를 스프링 빈으로 등록 할 때
@Configuration
public class UserConfiguration {

    /*@Bean
    public UserRepository userRepository(JdbcTemplate jdbcTemplate){
        return new UserRepository(jdbcTemplate);
    }*/
}
