package com.example.demo.basic_security;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception { //basic security
    //    auth.inMemoryAuthentication().withUser("amir").password("1234").authorities("ADMIN");
    auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }



}
