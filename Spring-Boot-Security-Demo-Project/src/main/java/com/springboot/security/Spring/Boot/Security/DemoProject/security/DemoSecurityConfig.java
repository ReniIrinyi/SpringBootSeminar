package com.springboot.security.Spring.Boot.Security.DemoProject.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails john= User.builder().username("John").password("{noop}test123").roles("EMPLOYEE").build();
//        UserDetails mary= User.builder().username("Mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
//        UserDetails jessica= User.builder().username("Jessica").password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
//
//        return new InMemoryUserDetailsManager(john, mary,jessica);
//    }

    @Bean
    UserDetailsManager userDetailsManager (DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/demo/members").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/demo/members/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/demo/members").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/demo/members").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/demo/members/**").hasRole("ADMIN")
        );
        http.csrf(csrf->csrf.disable());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }



}
