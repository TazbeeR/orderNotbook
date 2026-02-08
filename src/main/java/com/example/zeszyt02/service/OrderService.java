package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getOrders();
    Optional<Order> getOrder(long id);
    void addOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(long id);
}
