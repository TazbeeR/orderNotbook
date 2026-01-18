package com.example.zeszyt02.entity.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderSpiceItem {

    @NotBlank
    private String name;

    @NotBlank
    private short quantity;

    @NotBlank
    private BigDecimal price;

    @NotBlank
    private String description;
}
