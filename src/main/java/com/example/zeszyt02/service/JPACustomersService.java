package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.Customers;
import com.example.zeszyt02.repository.CustomersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPACustomersService implements CustomersService{
    private CustomersRepository customersRepository;

    public JPACustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public List<Customers> getCustomers() {
        return customersRepository.findAll();
    }

    @Override
    public Optional<Customers> getCustomer(long id) {return customersRepository.findById(id);}

    @Override
    public void addCustomer(Customers customers) { customersRepository.save(customers);}

    @Override
    public void updateCustomer(Customers customers) { customersRepository.save(customers);}

    @Override
    public void deleteCustomer(long id) {customersRepository.deleteById(id);}
}
