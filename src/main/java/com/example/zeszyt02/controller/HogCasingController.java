package com.example.zeszyt02.controller;

import com.example.zeszyt02.entity.HogCasing;
import com.example.zeszyt02.service.HogCasingService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hogcasing")
@CrossOrigin(origins = "http://localhost:3000")
public class HogCasingController {

    @Autowired
    private HogCasingService hogCasingsService;

    @GetMapping("/list")
    public List<HogCasing> getListOfHogCasings() {
        return hogCasingsService.getHogCasing();
    }

    @GetMapping("/{id}")
    public HogCasing getHogCasing(@PathVariable long id) {
        return hogCasingsService.getHogCasing(id)
                .orElseThrow(() -> new EntityNotFoundException("HogCasing not found with id: " + id));
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public HogCasing addHogCasing(@Valid @RequestBody HogCasing hogCasing) {
        hogCasingsService.addHogCasing(hogCasing);
        return hogCasing;
    }

    @PutMapping("/{id}")
    public HogCasing updateHogCasing(@PathVariable long id, @Valid @RequestBody HogCasing hogCasing) {
        hogCasing.setId(id);
        hogCasingsService.updateHogCasing(hogCasing);
        return hogCasing;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteHogcasing(@PathVariable long id) {
        hogCasingsService.deleteHogCasing(id);
        return Map.of(
                "message", "Deleted successfully",
                "id", id,
                "status", HttpStatus.OK.value()
        );
    }
}