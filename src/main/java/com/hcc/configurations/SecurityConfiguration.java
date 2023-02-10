package com.hcc.configurations;


import com.hcc.services.UserDetailsServiceImpl;
import com.hcc.utils.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //TODO: User details service implementation
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    //todo: custom password enconder

    @Autowired
    CustomPasswordEncoder customPasswordEncoder;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsServiceImpl)
                .passwordEncoder(customPasswordEncoder.getPasswordEncoder());

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }



}
