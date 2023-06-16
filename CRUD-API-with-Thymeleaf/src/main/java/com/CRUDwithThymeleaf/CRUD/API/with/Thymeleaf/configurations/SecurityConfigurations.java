package com.CRUDwithThymeleaf.CRUD.API.with.Thymeleaf.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfigurations {

    @Bean
     public UserDetailsManager userDetailsManager(DataSource dataSource)
    {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity)throws Exception
    {
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(form->
                        form
                                .loginPage("/showLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                );
        return httpSecurity.build();
    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.GET, "/demo/members").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET, "/demo/members/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST, "/demo/members").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT, "/demo/members").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE, "/demo/members/**").hasRole("ADMIN")
//        );
//        http.csrf(csrf->
//        csrf
//        .disable()
//        );
//        http.httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
}
