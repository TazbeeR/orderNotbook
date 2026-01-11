package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.Customers;

import java.util.List;
import java.util.Optional;

public interface CustomersService {

    List<Customers> getCustomers();
    Optional<Customers> getCustomer(long id);
    void addCustomer(Customers customer);
    void updateCustomer(Customers customer);
    void deleteCustomer(long id);
}
