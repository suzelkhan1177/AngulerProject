package com.exam.examportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
  
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	
		return super.authenticationManagerBean();
	}
	
	 @Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	  @Autowired
	 private jwtAuthentonFilter jwtAuthentonFilter;
	 
	  @Autowired
	 private UserDeatilsServicesImpl userDeatilsServiceImpl; 
	  
	  
	  
	  @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
		  
		  return new BCryptPasswordEncoder();
	  }
	  
	
	  

	  
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(this.userDeatilsServiceImpl).passwordEncoder(passwordEncoder());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		       .csrf()
		       .disable()
		       .cors()
		       .disable()
		       .authorizeRequests()
		       .antMatchers("/generate-token", "/user/", "/user/test").permitAll()
		       .antMatchers(HttpMethod.OPTIONS).permitAll()
		       .anyRequest().authenticated()
		       .and().exceptionHandling() .authenticationEntryPoint(unauthorizedHandler)
		       .and()
		       .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtAuthentonFilter,UsernamePasswordAuthenticationFilter.class);
	}

	
	  
}
