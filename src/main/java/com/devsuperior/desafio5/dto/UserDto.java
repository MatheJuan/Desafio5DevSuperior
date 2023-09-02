package com.devsuperior.desafio5.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

import com.devsuperior.desafio5.entities.User;

public class UserDto {
	private Long id;
	private String email;
	
	private List<String> roles = new ArrayList<>();

	public UserDto(User entity) {
		id = entity.getId();
		email = entity.getEmail();
		for(GrantedAuthority authority : entity.getRoles()) {
			roles.add(authority.getAuthority());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	 
	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, roles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(roles, other.roles);
	}
	
	
}
