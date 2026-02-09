package com.example.zeszyt02.controller;

import com.example.zeszyt02.entity.Customers;
import com.example.zeszyt02.service.CustomersService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomersService customersService;

    @GetMapping("/list")
    public List<Customers> getListOfCustomers() {
        return customersService.getCustomers();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Customers addCustomer(@Valid @RequestBody Customers customers) {
        customersService.addCustomer(customers);
        return customers;
    }

    @GetMapping("/{id}")
    public Customers getCustomer(@PathVariable long id) {
        return customersService.getCustomer(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Customers updateCustomer(@PathVariable long id, @Valid @RequestBody Customers customers) {
        customers.setId(id);
        customersService.updateCustomer(customers);
        return customers;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteCustomer(@PathVariable long id) {
        customersService.deleteCustomer(id);
        return Map.of("status", "deleted", "id", String.valueOf(id));
    }
}