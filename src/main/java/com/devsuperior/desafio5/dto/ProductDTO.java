package com.devsuperior.desafio5.dto;

import java.util.ArrayList;
import java.util.List;

import com.devsuperior.desafio5.entities.Category;
import com.devsuperior.desafio5.entities.Product;

 
public class ProductDTO {

	private Long id;

	private String name;

	private String description;

	private double price;

	private String imgurl;

	private List<CategoryDTO> categoryList = new ArrayList<>();

	
	
	public ProductDTO() {
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgurl = entity.getImgUrl();
		
		for(Category dto : entity.getCategories()) {
			categoryList.add(new CategoryDTO(dto));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public List<CategoryDTO> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CategoryDTO> categoryList) {
		this.categoryList = categoryList;
	}
 
	
	 
}
