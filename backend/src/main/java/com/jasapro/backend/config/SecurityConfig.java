package com.jasapro.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ✅ Fixed: use lambda
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/users/register").permitAll()
                        .requestMatchers("/api/users/**").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(basic -> {
                }); // ✅ Fixed: use lambda

        return http.build();
    }
}
