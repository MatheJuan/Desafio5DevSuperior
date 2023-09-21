package com.devsuperior.desafio5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.desafio5.dto.CategoryDTO;
import com.devsuperior.desafio5.dto.ProductDTO;
import com.devsuperior.desafio5.dto.ProductMinDTO;
import com.devsuperior.desafio5.entities.Category;
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
	public ProductDTO updateProduct(Long id, ProductDTO dto) {

		Product entity = productRepository.getReferenceById(id);
		DtoToEntity(dto, entity);
		entity = productRepository.save(entity);
		return new ProductDTO(entity);

	}

	@Transactional
	public ProductDTO insertProduct(ProductDTO dto) {
		Product entity = new Product();
		entity.setName(dto.getName());
		DtoToEntity(dto, entity);
		entity = productRepository.save(entity);
		return new ProductDTO(entity);
	}

	@Transactional()
	public void delete(Long id) {
		productRepository.deleteById(id);
	}

	private void DtoToEntity(ProductDTO dto, Product product) {
		product.setId(dto.getId());
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setImgUrl(dto.getImgurl());
		product.setPrice(dto.getPrice());
		product.getCategories().clear();
		for (CategoryDTO cat : dto.getCategoryList()) {
			Category category = new Category();
			cat.setId(cat.getId());
			product.getCategories().add(category);
		}
	}
}
