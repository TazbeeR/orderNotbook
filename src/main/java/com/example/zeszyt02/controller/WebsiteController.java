package com.example.zeszyt02.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteController {

    @GetMapping("/")
    public String landingPage(HttpSession session){

        return "index";
    }
    @GetMapping("/panel")
    public String contactPage(){
        return "panel";
    }
}