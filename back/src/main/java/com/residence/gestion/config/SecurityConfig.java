package com.residence.gestion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .cors() // Enable CORS
            .and()
            .authorizeHttpRequests()
            .requestMatchers("/api/auth/**").permitAll()
            .requestMatchers("/api/admin/**").hasRole("ADMIN")
            .requestMatchers("/api/resident/**").hasRole("RESIDENT")
            .requestMatchers("/api/technicien/**").hasAuthority("TECHNICIEN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginProcessingUrl("/api/auth/login") // Custom login URL
            .successHandler((request, response, authentication) -> {
                response.setContentType("application/json");
                response.getWriter().write("{\"message\": \"Login successful!\"}");
            })
            .failureHandler((request, response, exception) -> {
                response.setStatus(401);
                response.setContentType("application/json");
                response.getWriter().write("{\"error\": \"Invalid credentials\"}");
            })
            .and()
            .logout()
            .logoutUrl("/api/auth/logout") // Custom logout URL
            .logoutSuccessHandler((request, response, authentication) -> {
                response.setContentType("application/json");
                response.getWriter().write("{\"message\": \"Logout successful!\"}");
            });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
