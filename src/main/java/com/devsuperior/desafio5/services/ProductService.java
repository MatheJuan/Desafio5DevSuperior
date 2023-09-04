package com.devsuperior.desafio5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.desafio5.dto.ProductDTO;
import com.devsuperior.desafio5.dto.ProductMinDTO;
import com.devsuperior.desafio5.entities.Product;
import com.devsuperior.desafio5.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Product entity = productRepository.findById(id).get();
		return new ProductDTO(entity);
	}
	@Transactional(readOnly = true)
	public Page<ProductMinDTO> findAll(String name, Pageable page) {
		Page<Product> result = productRepository.searchByName(name, page);
		return result.map(x -> new ProductMinDTO(x));
	}
	
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		entity.setName(dto.getName());
		entity = productRepository.save(entity);
		return new ProductDTO(entity);
	}
}
