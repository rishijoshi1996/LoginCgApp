package com.cgapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
        //HTTP Basic authentication
       
//        .authorizeRequests()
//        .antMatchers("/loginapp").permitAll()
//        .antMatchers("/api/**").hasRole("ADMIN")
//        .and()
//        .formLogin().and().csrf().disable();
	}

//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		 auth.inMemoryAuthentication()
//        .withUser("admin").password("password").roles("ADMIN");
//        
//	}

}
