package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.repository.OrderRepository;
import com.examly.springapp.model.OrderModel;
import com.examly.springapp.tempmodel.OrderListModel;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
	
	@Autowired
	public OrderRepository orderRepo;
	
	@GetMapping("/user/{id}/orders")
	public List<OrderModel> getOrdersForUser(@PathVariable String id) {
		return orderRepo.findByUserId(id);
	}

	@GetMapping("/getAllOrders")
	public List<OrderModel> getAllOrders() {
		return orderRepo.findAll();
	}
	
	@PostMapping("/user/addorder")
	public boolean addorder(@RequestBody List<OrderModel> orderList) {
		
		orderList.forEach(list -> orderRepo.save(list));	
		return true;
	}
	
	@DeleteMapping("/user/deleteorder/{id}")
	public void deleteOrder(@PathVariable String orderId) {
		orderRepo.deleteById(orderId);
	}
	
	@DeleteMapping("/user/deleteall")
	public void deleteAll() {
		orderRepo.deleteAll();
	}
	
}
