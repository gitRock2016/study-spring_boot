package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	// TODO セキュリティを一時的に無効にしている
	    @Override
	    protected void configure(HttpSecurity http) throws Exception{
	        http.authorizeRequests().antMatchers("/").permitAll();
	    }
}
