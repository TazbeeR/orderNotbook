package com.example.zeszyt02.controller;

import com.example.zeszyt02.entity.Customers;
import com.example.zeszyt02.entity.DTO.OrderHogCasingItem;
import com.example.zeszyt02.entity.DTO.OrderSpiceItem;
import com.example.zeszyt02.entity.Spices;
import com.example.zeszyt02.service.CustomersService;
import com.example.zeszyt02.service.SpicesService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/spice")

public class SpisesController {

    private SpicesService spicesService;

    @GetMapping("/list")
    public String getListOfSpices(Model model) {
        List<Spices> spicesList = spicesService.getSpices();
        model.addAttribute("spiceslist", spicesList);
        return "spices/list";
    }

    @GetMapping("/add")
    public String initGetAddSpice(Model model) {
        model.addAttribute("spice", new Spices());
        return "spices/form";
    }

    @PostMapping("/add")
    public String addSpice(Spices spices, BindingResult result) {
        if (result.hasErrors()) {
            return "spices/form";
        }
        spicesService.addSpice(spices);
        return "redirect:/spice/list";
    }

    @GetMapping("/update/{id}")
    public String initGetUpdateSpice(Model model, @PathVariable long id) {
        model.addAttribute("spice", spicesService.getSpice(id));
        return "spices/form";
    }

    @PostMapping("/update/{id}")
    public String updateSpice(Spices spices, BindingResult result) {
        if (result.hasErrors()) {
            return "spices/form";
        }
        spicesService.updateSpice(spices);
        return "redirect:/spice/list";
    }

    @GetMapping("/delete/{id}")
    public String initGetDeleteSpice(Model model, @PathVariable long id) {
        Spices spice = spicesService.getSpice(id).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("spice", spice);
        return "spices/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteSpice(@RequestParam String confirmed, @PathVariable long id) {
        if (confirmed.equals("yes")) {
            spicesService.deleteSpice(id);
        }
        return "redirect:/spice/list";
    }
}
