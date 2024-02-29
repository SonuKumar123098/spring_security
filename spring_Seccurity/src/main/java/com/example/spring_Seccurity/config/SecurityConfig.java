package com.example.spring_Seccurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // It helps in encrypting the password
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    //define user roles
    @Bean
    public  UserDetailsService getUserDetailsService(){
//        UserDetails student= User.withUsername("sunny")
//                .password(getPasswordEncoder().encode("sunny123"))
//                .roles("STUDENT")
//                .build();
//        UserDetails student1= User.withUsername("suraj")
//                .password(getPasswordEncoder().encode("suraj123"))
//                .roles("STUDENT")
//                .build();
//        UserDetails admin= User.withUsername("rahul")
//                .password(getPasswordEncoder().encode("rahul123"))
//                .roles("ADMIN")
//                .build();
//
//        return  new InMemoryUserDetailsManager(student,admin,student1);
        // above code are for inmemoryAuthentication
        return  new CustomUserDetailService();
    }


    //first create bean of securityfilterChain class while implementing security
    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/public/**")
                .permitAll()
                .requestMatchers("/student/**")
                .hasAnyRole("STUDENT","ADMIN")
                .requestMatchers(("/admin/**"))
                .hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

        return httpSecurity.build();
    }
    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
        return daoAuthenticationProvider;
    }
}
