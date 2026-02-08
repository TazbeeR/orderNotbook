package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.Order;
import com.example.zeszyt02.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPAOrderService implements OrderService {
    private final OrderRepository orderRepository;

    public JPAOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrders() {return orderRepository.findAll(); }

    @Override
    public Optional<Order> getOrder(long id) {return orderRepository.findById(id); }

    @Override
    public void addOrder(Order order) {orderRepository.save(order); }

    @Override
    public void updateOrder(Order order) {orderRepository.save(order); }

    @Override
    public void deleteOrder(long id) {orderRepository.deleteById(id); }

}
