package com.example.zeszyt02.controller;

import com.example.zeszyt02.entity.Customers;
import com.example.zeszyt02.service.CustomersService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")

public class CustomerController {
    @Autowired
    private CustomersService customersService;

    @GetMapping("/list")
    public String getListOfCustomers(Model model) {
        List<Customers> customersList = customersService.getCustomers();
        model.addAttribute("customers", customersList);
        return "/customer/list";
    }

    @GetMapping("/add")
    public String initAddCustomer(Model model) {
        model.addAttribute("customer", new Customers());
        return "/customer/form";
    }

    @PostMapping("/add")
    public String addCustomer(@Valid Customers customers, BindingResult result) {
        if (result.hasErrors()) {
            return "/customer/form";
        }
        customersService.addCustomer(customers);
        return "redirect:/customer/list";
    }

    @GetMapping("/update/{id}")
    public String initUpdateCustomer(@PathVariable long id, Model model) {
        model.addAttribute("customer", customersService.getCustomer(id));
        return "/customer/form";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@Valid Customers customers, BindingResult result) {
        if (result.hasErrors()) {
            return "/customer/form";
        }
        customersService.updateCustomer(customers);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete/{id}")
    public String initDeleteCustomer(@PathVariable long id,  Model model) {
        Customers customers = customersService.getCustomer(id).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("customer", customers);
        return "/customer/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteCustomer(@RequestParam String confirmed, @PathVariable long id) {
        if (confirmed.equals("yes")){
            customersService.deleteCustomer(id);
        }
        return "redirect:/customer/list";
    }
}
