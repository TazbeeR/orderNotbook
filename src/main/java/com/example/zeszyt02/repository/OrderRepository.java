package com.example.zeszyt02.repository;

import com.example.zeszyt02.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
