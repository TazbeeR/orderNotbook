package com.example.zeszyt02.controller;

import com.example.zeszyt02.entity.BeefCasing;
import com.example.zeszyt02.service.BeefCasingService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/beefcasing")
@CrossOrigin(origins = "http://localhost:3000")

public class BeefCasingController {
    @Autowired
    private BeefCasingService beefCasingService;

    @GetMapping("/list")
    public List<BeefCasing> getBeefCasingList(){
        return beefCasingService.findAllBeefCasings();
    }

    @GetMapping("/{id}")
    public BeefCasing getBeefCasing(@PathVariable Long id){
        return beefCasingService.findBeefCasingById(id)
                .orElseThrow(()-> new EntityNotFoundException("BeefCasing not found" + id));
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public BeefCasing addBeefCasing(@Valid @RequestBody BeefCasing beefCasing) {
        beefCasingService.saveBeefCasing(beefCasing);
        return beefCasing;
    }

    @PutMapping("/{id}")
    public BeefCasing beefCasingUpdate(@PathVariable Long id, @Valid @RequestBody BeefCasing beefCasing) {
        beefCasing.setId(id);
        beefCasingService.saveBeefCasing(beefCasing);
        return beefCasing;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteAdditive(@PathVariable long id) {
        beefCasingService.deleteBeefCasing(id);
        return Map.of(
                "message", "Deleted successfully",
                "id", id,
                "status", HttpStatus.OK.value()
        );
    }
}
