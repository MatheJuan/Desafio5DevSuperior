package com.devsuperior.desafio5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.desafio5.entities.OrdemItemPK;
import com.devsuperior.desafio5.entities.OrderItem;
 
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrdemItemPK>{

}
