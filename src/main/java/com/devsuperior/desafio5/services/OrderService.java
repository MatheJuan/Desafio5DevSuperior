package com.devsuperior.desafio5.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.devsuperior.desafio5.dto.OrderDTO;
import com.devsuperior.desafio5.dto.OrderItemDTO;
import com.devsuperior.desafio5.entities.Order;
import com.devsuperior.desafio5.entities.OrderItem;
import com.devsuperior.desafio5.entities.OrderStatus;
import com.devsuperior.desafio5.entities.Product;
import com.devsuperior.desafio5.entities.User;
import com.devsuperior.desafio5.repositories.OrderItemRepository;
import com.devsuperior.desafio5.repositories.OrderRepository;
import com.devsuperior.desafio5.repositories.ProductRepository;
import com.devsuperior.desafio5.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	@Autowired
	private ProductRepository productrepository;

	@Autowired
	private UserService userService;

	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private AuthService authService;

	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order order = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso nao encontrado"));
		authService.validateSelfOrAdmin(order.getClient().getId());
		return new OrderDTO(order);
	}

	@Transactional
	public OrderDTO insert(OrderDTO dto) {

		Order order = new Order();
		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.WAITING_PAYMENT);

		User user = userService.authentication();
		order.setClient(user);
		for (OrderItemDTO itemDto : dto.getItems()) {
			Product product = productrepository.getReferenceById(itemDto.getProductId());
			OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
			order.getItems().add(item);
		}
		repository.save(order);
		orderItemRepository.saveAll((order.getItems()));
		return new OrderDTO(order);
	}
}
