package com.example.democonfigserverref.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                .requestMatchers(new AntPathRequestMatcher("/status")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/beans/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/caches/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/beans/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/health/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/info/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/conditions/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/configprops/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/env/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/loggers/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/heapdump/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/threaddump/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/prometheus/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/metrics/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/scheduledtasks/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/mappings/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/refresh/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/status/features/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/encrypt/status")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/encrypt/**")).denyAll()
                .requestMatchers(new AntPathRequestMatcher("/decrypt/**")).denyAll()

                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

}
