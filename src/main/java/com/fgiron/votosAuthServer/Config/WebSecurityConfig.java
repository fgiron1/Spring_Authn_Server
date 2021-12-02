package com.fgiron.votosAuthServer.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public WebSecurityConfig() {}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.cors()
				.and()
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests(configurer ->
						configurer
								.antMatchers(
										"/error",
										"/login"
								)
								.permitAll()
								.anyRequest()
								.authenticated()
				);
	}
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
        UserDetails user1 = User
				.withUsername("user")
				.authorities("USER")
				.passwordEncoder(passwordEncoder::encode)
				.password("1234")
				.build();
		
        
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(user1);
		return manager;
	}

}
