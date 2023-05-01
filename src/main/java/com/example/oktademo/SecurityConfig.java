package com.example.oktademo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/" )
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Client()
                .and()
                .oauth2Login()
                .and()
                .oauth2ResourceServer().jwt();
        http.headers().frameOptions().disable();
        return http.build();
    }
}