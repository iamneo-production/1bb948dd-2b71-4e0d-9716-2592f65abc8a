package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.OrderModel;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, String> {
	
	List<OrderModel> findByUserId(String userId);
	List<OrderModel> findAll();


}
