package com.dwa.boutique;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity 

public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers( //Rutas de accesos libre
				"/",
				"/images/**",
				"/css/**",
				"/js/**",
				"/acceso/**",
				"/acceso/acceder"
				).permitAll()
		.anyRequest().authenticated() //Cualquier otra ruta es con token
		.and()
		.formLogin()
		.loginPage("/acceso/acceder")//Esta ruta se usa para validar al usuario
		.successForwardUrl("/acceso/acceder")
		.permitAll()
		.and()
		.logout()
		.permitAll();
		
	}

}
