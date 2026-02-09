package com.example.zeszyt02.controller;

import com.example.zeszyt02.entity.Additive;
import com.example.zeszyt02.service.AdditiveService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/additive")
@CrossOrigin(origins = "http://localhost:3000")

public class AdditiveController {

    @Autowired
    private AdditiveService additiveService;

    @GetMapping("/list")
    public List<Additive> getAdditives() {
        return additiveService.findAllAdditives();
    }

    @GetMapping("{id}")
    public Additive getAdditive(@PathVariable long id) {
        return additiveService.findAdditiveById(id)
                .orElseThrow(() -> new EntityNotFoundException("Additive not found" + id));
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Additive additive(@Valid @RequestBody Additive additive) {
        additiveService.saveAdditive(additive);
        return additive;
    }

    @PutMapping("/{id}")
    public Additive additive(@Valid @RequestBody Additive additive, @PathVariable long id) {
        additive.setId(id);
        additiveService.saveAdditive(additive);
        return additive;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteAdditive(@PathVariable long id) {
        additiveService.deleteAdditive(id);
        return Map.of(
                "message", "Deleted successfully",
                "id", id,
                "status", HttpStatus.OK.value()
        );
    }
}
