package com.akuniyoshi.springboot.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akuniyoshi.springboot.backend.apirest.entity.Client;
import com.akuniyoshi.springboot.backend.apirest.service.IClienteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteRestController.class);

	@Autowired
	private IClienteService clienteService;

	@GetMapping("/clients")
	public List<Client> index() {
		return clienteService.findAll();
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Client client = null;
		Map<String, Object> response = new HashMap<>();

		try {

			client = clienteService.findById(id);

		} catch (DataAccessException e) {
			response.put("message", "Database error");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (client == null) {
			LOGGER.error("The client id:" + id + " " + "no exist in the DB");
			response.put("error", "The client id:" + id + " " + "no exist in the DB");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	@PostMapping("/clients")
	public ResponseEntity<?> create(@Valid @RequestBody Client client, BindingResult result) {

		Client clientNew = new Client();
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
//			List<String> errors = new ArrayList<>();
//
//			for (FieldError err : result.getFieldErrors()) {
//				errors.add("The field " + err.getField() + "' " + err.getDefaultMessage());
//			}

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "The field " + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {

			clientNew = clienteService.save(client);

		} catch (DataAccessException e) {
			response.put("mensaje", "Database error");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "The client has created with successful");
		response.put("cliente", clientNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Client client, BindingResult result, @PathVariable Long id) {

		Client currentClient = clienteService.findById(id);

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
//			List<String> errors = new ArrayList<>();
//
//			for (FieldError err : result.getFieldErrors()) {
//				errors.add("The field " + err.getField() + "' " + err.getDefaultMessage());
//			}

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "The field " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (currentClient == null) {
			LOGGER.error("error", "The client id:" + id + " " + "no exist in the DB");
			response.put("error", "The client id:" + id + " " + "no exist in the DB");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		currentClient.setName(client.getName());
		currentClient.setLastName(client.getLastName());
		currentClient.setEmail(client.getEmail());

		try {

			clienteService.save(currentClient);

		} catch (DataAccessException e) {
			response.put("mensaje", "Database error");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "The client has updated with successful");
		response.put("cliente", currentClient);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/clients/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {

			clienteService.delete(id);

		} catch (DataAccessException e) {
			LOGGER.error("error: " + e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("mensaje", "Database error");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "The client has deleted with successful");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
