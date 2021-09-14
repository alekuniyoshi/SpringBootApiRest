package com.akuniyoshi.springboot.backend.apirest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akuniyoshi.springboot.backend.apirest.dao.IusuarioDao;
import com.akuniyoshi.springboot.backend.apirest.entity.Usuario;


/* UserDetailsService: es una interface propia de Spring
 * para trabjar con JPA,JDBC u otro proveedor para implementear el proceso de login
 * 
 * @Service con esta anotacion la registramos como un bean
 * 
 * 
 * */
@Service
public class IUsuarioService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(IUsuarioService.class);

	@Autowired
	IusuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioDao.findByUsername(username);

		if (usuario == null) {
			logger.error("Error en el login : NO existe el usuario: " + username + " en el sistema");
			throw new UsernameNotFoundException(
					"Error en el login : NO existe el usuario: " + username + " en el sistema");
		}

		/* no se asincronico es un flujo de datos*/
		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority())).collect(Collectors.toList());

		return new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(), true, true, true,
				authorities);
	}

}
