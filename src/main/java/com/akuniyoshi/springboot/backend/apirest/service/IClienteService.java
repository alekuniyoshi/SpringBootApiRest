package com.akuniyoshi.springboot.backend.apirest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.akuniyoshi.springboot.backend.apirest.entity.Client;

public interface IClienteService {

	public List<Client> findAll();
	
	public Page<Client> findAll(Pageable pageable);

	public Client save(Client client);

	public void delete(Long id);

	public Client findById(Long id);
}
