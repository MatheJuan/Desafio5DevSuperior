package com.devsuperior.desafio5.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.desafio5.dto.CategoryDTO;
import com.devsuperior.desafio5.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		List<CategoryDTO> cate = service.findAll();
		return ResponseEntity.ok(cate);
	}
}
