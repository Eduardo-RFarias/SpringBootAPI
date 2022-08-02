package com.example.spring_test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfiguration {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.authorizeRequests(authorizeRequests -> {
			authorizeRequests.anyRequest().authenticated();
		}).csrf(csrf -> {
			csrf.disable();
		}).httpBasic().and().build();
	}
}