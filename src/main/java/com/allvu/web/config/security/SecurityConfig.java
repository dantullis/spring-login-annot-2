package com.allvu.web.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configures the access and authentication
 * Configuration: Indicates to "Spring framework" that this class
 * 		can be used as a source of bean definitions.
 * @author dan tullis
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Hard coded user and role in this example.
	 * Will show how to use DB in future demo project
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}

	/**
	 * Setting up access and custom login form
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/admin/**").access("hasRole('ROLE_USER')")
			.and()
				.formLogin().loginPage("/login").failureUrl("/login?error")
					.usernameParameter("username").passwordParameter("password")
				
			.and()
				.logout().logoutSuccessUrl("/login?logout")
			.and()
				.csrf(); 		
	}
}