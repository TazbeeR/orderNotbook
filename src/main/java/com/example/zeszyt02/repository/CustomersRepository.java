package com.example.zeszyt02.repository;

import com.example.zeszyt02.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository <Customers, Long> {
}
