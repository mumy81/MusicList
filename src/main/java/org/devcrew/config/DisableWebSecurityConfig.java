package org.devcrew.config;

import org.devcrew.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;


public class DisableWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		// All requests send to the Web Server request must be authenticated
		// http.authorizeRequests().antMatchers("/api/user/add").permitAll().antMatchers("/api/user/login").permitAll() http.anyRequest().authenticated();
		http.authorizeRequests().antMatchers("/**").permitAll();

		// Use AuthenticationEntryPoint to authenticate user/password
		http.httpBasic().authenticationEntryPoint(authEntryPoint);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailServiceImpl).passwordEncoder(passwordEncoder());

	}

}