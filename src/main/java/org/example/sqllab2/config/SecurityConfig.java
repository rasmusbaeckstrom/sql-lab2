package org.example.sqllab2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(GET, "/api/categories/**").permitAll()
                        .requestMatchers(POST, "/api/categories/**").hasRole("ADMIN")

                        .requestMatchers(GET, "/api/places/user/**").hasRole("USER")
                        .requestMatchers(GET, "/api/places/**").permitAll()
                        .requestMatchers(GET, "/api/places/category/**").permitAll()
                        .requestMatchers(GET, "/api/places/radius").permitAll()
                        .requestMatchers(POST, "/api/places/**").hasRole("USER")

                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("rasmus")
                .password("rasmus")
                .roles("USER", "ADMIN")
                .build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("casey")
                .password("casey")
                .roles("USER")
                .build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("maya")
                .password("maya")
                .roles("USER")
                .build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("sky")
                .password("sky")
                .roles("USER")
                .build());
        return manager;
    }
}