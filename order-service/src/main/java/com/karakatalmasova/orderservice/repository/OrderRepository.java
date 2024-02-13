package com.karakatalmasova.orderservice.repository;

import com.karakatalmasova.orderservice.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
