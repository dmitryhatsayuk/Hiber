package ru.test.hiber;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(requests -> requests
                        .requestMatchers("/persons/by-city")
                        .permitAll()
                        .anyRequest()
                        .authenticated())

                .formLogin(Customizer.withDefaults()).build();
    }
}