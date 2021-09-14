package com.akuniyoshi.springboot.backend.apirest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;

	/*
	 * Se configura los permisos de los endpoints
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permiteAll()") // Para generar el token, todos tienen acceso en este caso, seria
												// publico
				.checkTokenAccess("isAuthenticated()");// Acceso para validar el token que se esta enviando, en este
														// caso solo pueden acceder los clientes autenticados
	}

	/*
	 * Se configuran los clientes (otras aplicaciones) que acceden a nuestros
	 * recursos
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("angularApp").secret(passwordEncoder.encode("12345")).scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token") // Para inicio de sesion con login, el usuario tiene
																	// que tener user y pass
				.accessTokenValiditySeconds(3600) // tiempo de validacion en seg.
				.refreshTokenValiditySeconds(3600);// para tener un token renovado sin tener que renovar sesion
	}

	/*
	 * Se encarga de todo el proceso de autenticacion y validar el token. Cada
	 * inicio de sesion se envia nuestro usuario y pass si todo sale bien, genera el
	 * token, se lo entrega al usuario para que acceda a los recursos, antes de
	 * acceder a los recursos se tiene que validar
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(accessTokenConvert());
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConvert());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConvert() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVATE);
		jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLIC);
		return jwtAccessTokenConverter;
	}

}
