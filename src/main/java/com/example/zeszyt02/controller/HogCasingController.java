package com.example.zeszyt02.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.zeszyt02.entity.HogCasing;
import com.example.zeszyt02.service.HogCasingService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hogcasing")

public class HogCasingController {

    @Autowired
    private HogCasingService hogCasingsService;

    @GetMapping("/list")
    public String getListOfHogCasings(Model model) {
        List<HogCasing> hogCasingList = hogCasingsService.getHogCasing();
        model.addAttribute("hogcasings", hogCasingList);
        return "hogcasings/list";
    }

    @GetMapping("/add")
    public String initAddHogCasing(Model model) {
        model.addAttribute("hogcasing", new HogCasing());
        return "hogcasings/form";
    }

    @PostMapping("/add")
    public String addHogCasing(@Valid HogCasing hogCasing, BindingResult result) {
        if (result.hasErrors()) {
            return "hogcasing/form";
        }
        hogCasingsService.addHogCasing(hogCasing);
        return "redirect:/hogcasing/list";
    }

    @GetMapping("/update/{id}")
    public String initUpdateHogCasing(Model model, @PathVariable long id) {
        model.addAttribute("hogcasing", hogCasingsService.getHogCasing(id));
        return "/hogcasings/form";
    }

    @PostMapping("/update/{id}")
    public String updateHogCasing(@Valid HogCasing hogCasing, BindingResult result) {
        if (result.hasErrors()) {
            return "hogcasings/form";
        }
        hogCasingsService.updateHogCasing(hogCasing);
        return "redirect:/hogcasing/list";
    }

    @GetMapping("/delete/{id}")
    public String initDeleteHogCasing(@PathVariable long id, Model model) {
        HogCasing hogCasing = hogCasingsService.getHogCasing(id).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("hogcasing", hogCasing);
        return "hogcasings/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteHogcasing(@RequestParam String confirmed, @PathVariable long id) {
        if ("yes".equals(confirmed)) {
            hogCasingsService.deleteHogCasing(id);
        }
        return "redirect:/hogcasing/list";
    }
}
