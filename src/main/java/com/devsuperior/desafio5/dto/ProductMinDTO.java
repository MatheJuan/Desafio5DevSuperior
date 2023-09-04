package com.devsuperior.desafio5.dto;

import com.devsuperior.desafio5.entities.Product;

public class ProductMinDTO {
	private Long id;
	private String nome;
	private String imgUrl;
	private Double price;
	
	
	public ProductMinDTO() {
	}


	public ProductMinDTO(Long id, String nome, String imgUrl, Double price) {
		this.id = id;
		this.nome = nome;
		this.imgUrl = imgUrl;
		this.price = price;
	}
	public ProductMinDTO(Product entity) {
		id= entity.getId();
		nome=entity.getName();
		imgUrl= entity.getImgUrl();
		price= entity.getPrice();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public Double getPriceo() {
		return price;
	}


	public void setPreco(Double price) {
		this.price = price;
	}
	 
}
