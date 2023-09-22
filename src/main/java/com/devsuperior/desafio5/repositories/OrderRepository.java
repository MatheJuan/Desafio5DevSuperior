package com.devsuperior.desafio5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.desafio5.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
