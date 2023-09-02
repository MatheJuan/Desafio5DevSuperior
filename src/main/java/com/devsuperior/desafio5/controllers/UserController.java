package com.devsuperior.desafio5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.desafio5.dto.UserDto;
import com.devsuperior.desafio5.services.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "/me")
	public ResponseEntity<UserDto> findLogin() {
		UserDto dto = service.getLogin();
		return ResponseEntity.ok(dto);
	}

}

