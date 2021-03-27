package com.akuniyoshi.springboot.backend.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akuniyoshi.springboot.backend.apirest.entity.Client;

public interface IclienteDao extends JpaRepository<Client, Long> {

}
