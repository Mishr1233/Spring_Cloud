package com.cg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class AppSecurityConfig {
	
	
	
	@SuppressWarnings("removal")
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.authorizeRequests().requestMatchers("/login.jsp").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic();
	}
	
//   @Bean
//	protected UserDetailsService userDetailsService() {
//		
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("shiv").password("1234").roles("USER").build());
//		
//		return new InMemoryUserDetailsManager(users);
//	}
//	
	
	
	
//	 @Bean
//	    public UserDetailsService userDetailsService() {
//	        // Example: Creating an in-memory user (Use a database in real applications)
//	        UserDetails user = User.withUsername("admin")
//	                .password("{noop}password") // {noop} means no password encoding
//	                .roles("ADMIN")
//	                .build();
//
//	        return new InMemoryUserDetailsManager(user);
//}
	 
}
