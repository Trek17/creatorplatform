package com.trek.creatorplatform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder encoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
        .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/users/**","/api/contents/**").permitAll()
//                        .anyRequest().permitAll()
//                        .anyRequest().authenticated()
        );

        return http.build();
    }
}
