package com.akuniyoshi.springboot.backend.apirest.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;



/**
 * @author alejandro
 * 
 * Clase de configuracion del servidor de recursos OAUTH, que se encarga de dar aceesos a los clientes
 * a los recursos de la aplicacion, cuando el token sea valido
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/clients")
		.permitAll()
		.anyRequest()
		.authenticated();
	}

}
