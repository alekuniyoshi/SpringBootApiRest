package com.akuniyoshi.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.akuniyoshi.springboot.backend.apirest.entity.Client;

public interface IclienteDao extends CrudRepository<Client, Long> {

}
