package com.example.zeszyt02.controller;

import com.example.zeszyt02.entity.SheepCasing;
import com.example.zeszyt02.service.SheepCasingService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sheepcasing")

public class SheepCasingController {

    @Autowired
    private SheepCasingService sheepCasingService;

    @GetMapping("/list")
    public String sheepCasingList(Model model) {
        List<SheepCasing>  sheepCasingsList = sheepCasingService.getSheepCasings();
        model.addAttribute("sheepcasings", sheepCasingsList);
        return "/sheepcasings/list";
    }

    @GetMapping("/add")
    public String initAddSheepCasing(Model model) {
        model.addAttribute("sheepcasing", new SheepCasing());
        return "/sheepcasings/form";
    }

    @PostMapping("/add")
    public String addSheepCasing(SheepCasing sheepCasing, BindingResult result) {
        if (result.hasErrors()) {

        }
        sheepCasingService.addSheepCasing(sheepCasing);
        return "redirect:/sheepcasing/list";
    }

    @GetMapping("/update/{id}")
    public String initSheepCasing(@PathVariable long id, Model model) {
        model.addAttribute("sheepcasing", sheepCasingService.getSheepCasing(id));
        return "/sheepcasings/form";
    }

    @PostMapping("/update/{id}")
    public String updateSheepCasing(@Valid SheepCasing sheepCasing, BindingResult result) {
        if (result.hasErrors()) {
            return "/sheepcasings/form";
        }
        sheepCasingService.updateSheepCasing(sheepCasing);
        return "redirect:/sheepcasing/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteSheepCasing(@PathVariable long id, Model model) {
    SheepCasing sheepCasing = sheepCasingService.getSheepCasing(id).orElseThrow(EntityNotFoundException::new);
    model.addAttribute("sheepcasing", sheepCasing);
    return "/sheepcasings/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteSheepCasing(@RequestParam String confirmed, @PathVariable long id) {
        if ("yes".equals(confirmed)) {
            sheepCasingService.deleteSheepCasing(id);
        }
        return "redirect:/sheepcasing/list";
    }
}
