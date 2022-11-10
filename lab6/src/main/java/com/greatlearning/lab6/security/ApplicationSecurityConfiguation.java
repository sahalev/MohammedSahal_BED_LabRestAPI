package com.greatlearning.lab6.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.lab6.service.DomainUserDetailsService;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguation extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private  DomainUserDetailsService userDetailsService;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * 
		 * auth.inMemoryAuthentication()
		 * .withUser(users.username("sahal").password("Welcome1$").roles("ADMIN"))
		 * .withUser(users.username("john").password("Welcome1$").roles("USER"));
		 */
		
		auth
		.userDetailsService(this.userDetailsService)
		.passwordEncoder(passwordEncoder());	
	}
	
	
	
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		http.
		authorizeRequests()
		.antMatchers(HttpMethod.GET,"/students/list/**")
		.hasAnyRole("USER","ADMIN")
		.antMatchers("/h2-console/**","/login**")
		.permitAll()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/")
		.hasAnyRole("USER","ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/students/save/**")
		.hasAnyRole("USER","ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/students/showForm/**")
		.hasAnyRole("USER","ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/students/edit/**")
		.hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/students/delete/**")
		.hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling()
		.accessDeniedPage("/students/access-denied");
		
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	

}
