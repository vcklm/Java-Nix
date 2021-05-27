package com_nix_ragency;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("victor")
                .password("qwe")
                .roles("rieltor")
                .and()
                .withUser("alex")
                .password("asd")
                .roles("owner")
                .and()
                .withUser("alex")
                .password("asd")
                .roles("client");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/rieltor").hasRole("rieltor")
                .antMatchers("/owner").hasAnyRole("rieltor", "owner")
                .antMatchers("/client").hasAnyRole("client", "owner", "rieltor")
                .antMatchers("/home").permitAll()
                .and()
                .formLogin();
    }
    }

