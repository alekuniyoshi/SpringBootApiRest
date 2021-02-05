package com.akuniyoshi.springboot.backend.apirest.service;

import java.util.List;

import com.akuniyoshi.springboot.backend.apirest.entity.Client;

public interface IClienteService {

	public List<Client> findAll();

	public Client save(Client client);

	public void delete(Long id);

	public Client findById(Long id);
}
