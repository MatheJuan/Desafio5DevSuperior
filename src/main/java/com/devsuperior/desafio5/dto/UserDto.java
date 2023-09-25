package com.devsuperior.desafio5.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
 
import com.devsuperior.desafio5.entities.User;

public class UserDto {
	private Long id;
	private String email;
	private String phone;
	private LocalDate birth;
	
	private List<String> roles= new ArrayList<>();
	
	public UserDto() {
	}
	public UserDto(User entity) {
		 id = entity.getId();
		 email = entity.getEmail();
		 phone = entity.getPhone();
		 birth = entity.getBirthDate();
		 for(GrantedAuthority role : entity.getAuthorities()) {
			 roles.add(role.getAuthority());
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
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
		return Objects.equals(email, other.email);
	}
}
	
	
