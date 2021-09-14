package com.akuniyoshi.springboot.backend.apirest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author alejandro
 *
 *         Configurando Spring security con la clase de servicio
 *         userDetailsService, hay que registrarla en el authentication manager
 *         para poder usarla con JPA
 * 
 *
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userService;

	@Bean
	public BCryptPasswordEncoder passWordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/* registrando el servicio userDetailService que creamos */
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userService).passwordEncoder(passWordEncoder());
	}

	@Bean("authenticationManager")
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
	/* Se agregan reglas para los endpoints en el http security, desde el lado de spring security
	 * SessionCreationPolicy.STATELESS porque vamos a manejar los permisos con jwttoken, en caso de ser una API REST tambien no haria falta la seguridad solo seria por token
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()	
		.csrf().disable() //Se deshabilita porque estamos trabajando con angular
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
