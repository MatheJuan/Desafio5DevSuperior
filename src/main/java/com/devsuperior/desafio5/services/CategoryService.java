package com.devsuperior.desafio5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.desafio5.dto.CategoryDTO;
import com.devsuperior.desafio5.entities.Category;
import com.devsuperior.desafio5.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<CategoryDTO> findAll(){
		List<Category> cate = repository.findAll();
		return cate.stream().map(x -> new CategoryDTO(x)).toList();
	}
}
