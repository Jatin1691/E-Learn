package com.elearn.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(auth->{
            auth
                    .requestMatchers("/api/v1/auth/login").permitAll()
                    .requestMatchers(HttpMethod.GET,"/api/v1/**").hasAnyRole("GUEST","ADMIN")
                    .requestMatchers(HttpMethod.POST,"/api/v1/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT,"/api/v1/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE,"api/v1/**").hasRole("ADMIN")

                    .anyRequest()
                    .authenticated();
        });

        return httpSecurity.build();
    }
}
