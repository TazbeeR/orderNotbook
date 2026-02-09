package com.example.zeszyt02.controller;

import com.example.zeszyt02.entity.Spices;
import com.example.zeszyt02.service.SpicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spices")
@CrossOrigin(origins = "http://localhost:3000")
public class SpicesController {

    @Autowired
    private SpicesService spicesService;

    @GetMapping("/list")
    public List<Spices> getAllSpices() {
        return spicesService.getSpices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Spices> getSpice(@PathVariable long id) {
        return spicesService.getSpice(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Spices addSpice(@RequestBody Spices spices) {
        spicesService.addSpice(spices);
        return spices;
    }

    @PutMapping("/{id}")
    public Spices updateSpice(@PathVariable long id, @RequestBody Spices spices) {
        spices.setId(id);
        spicesService.updateSpice(spices);
        return spices;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpice(@PathVariable long id) {
        if (spicesService.getSpice(id).isPresent()) {
            spicesService.deleteSpice(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}