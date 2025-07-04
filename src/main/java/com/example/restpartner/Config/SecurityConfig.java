package com.example.restpartner.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/assets/**").permitAll();
            auth.requestMatchers("/h2-console/**").permitAll();

            auth.requestMatchers("/**").permitAll();
        });
        http.headers((headers) -> headers.frameOptions().sameOrigin());

        http.formLogin(login -> {
            login.loginPage("/login").successHandler(new CustomAuthenticationSuccessHandler()).permitAll();
        });

        http.csrf(AbstractHttpConfigurer::disable);

        http.logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
        );

        return http.build();
    }
}
