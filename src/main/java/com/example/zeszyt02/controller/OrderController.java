package com.example.zeszyt02.controller;

import com.example.zeszyt02.entity.Customers;
import com.example.zeszyt02.entity.DTO.OrderHogCasingItem;
import com.example.zeszyt02.entity.DTO.OrderItem;
import com.example.zeszyt02.entity.DTO.OrderSpiceItem;
import com.example.zeszyt02.entity.Order;
import com.example.zeszyt02.service.CustomersService;
import com.example.zeszyt02.service.OrderService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//@Controller
//@RequestMapping("/order")
//public class OrderController {
//
//    @Autowired
//    private OrderService orderService;
//    private CustomersService customersService;
//    private OrderSpiceItem orderSpiceItem;
//    private OrderHogCasingItem orderHogCasingItem;
//
//    @GetMapping("/list")
//    public String list(Model model) {
//        List<Order> orderList = orderService.getOrders();
//        model.addAttribute("orderlist", orderList);
//        return "orders/list";
//    }
//
//    @GetMapping("/add")
//    public String initAddOrderItem(Model model) {
//        List<Customers> customersList = customersService.getCustomers();
//        model.addAttribute("customer");
//        return "orders/form";
//    }
//
//    @PostMapping("/add")
//    public String addOrder(HttpSession session, Model model, @Valid Order order,  BindingResult result) {
//        if  (result.hasErrors()) {
//            return "orders/form";
//        }
//        List<OrderItem> baseOrderItemList = new ArrayList<>();
//
//
//
//        return "success";
//    }
//}
