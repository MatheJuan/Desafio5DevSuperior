package com.devsuperior.desafio5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.desafio5.entities.User;
import com.devsuperior.desafio5.services.exceptions.ForbiddenException;

@Service
public class AuthService {
	
	@Autowired
	private UserService userService;
	
	public void validateSelfOrAdmin(long userId) {
	User u = userService.authentication();
		if(!u.hasRole("ROLE_ADMIN") && !u.getId().equals(userId)) {
			throw new ForbiddenException("Acesso negado.");
		}
	}
}
