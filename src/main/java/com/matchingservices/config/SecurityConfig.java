///**
// * 
// */
//package com.matchingservices.config;
//
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @author apoorvatejavanam
// *
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig
//    extends WebSecurityConfigurerAdapter implements ApplicationContextAware {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	http.authorizeRequests().antMatchers("/").permitAll().and()
//    	.csrf().disable();
//    }
//
//}
// 