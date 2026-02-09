package com.example.zeszyt02.controller;

import com.example.zeszyt02.entity.SheepCasing;
import com.example.zeszyt02.service.SheepCasingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sheepcasing")
@CrossOrigin(origins = "http://localhost:3000")
public class SheepCasingController {

    @Autowired
    private SheepCasingService sheepCasingService;

    @GetMapping("/list")
    public List<SheepCasing> sheepCasingList() {
        return sheepCasingService.getSheepCasings();
    }

    @PostMapping("/add")
    public ResponseEntity<SheepCasing> addSheepCasing(@Valid @RequestBody SheepCasing sheepCasing) {
        SheepCasing saved = sheepCasingService.addSheepCasing(sheepCasing);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SheepCasing> updateSheepCasing(@PathVariable long id, @Valid @RequestBody SheepCasing sheepCasing) {
        sheepCasing.setId(id);
        sheepCasingService.updateSheepCasing(sheepCasing);
        return ResponseEntity.ok(sheepCasing);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SheepCasing> getOne(@PathVariable long id) {
        return sheepCasingService.getSheepCasing(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSheepCasing(@PathVariable long id) {
        sheepCasingService.deleteSheepCasing(id);
        return ResponseEntity.noContent().build();
    }
}