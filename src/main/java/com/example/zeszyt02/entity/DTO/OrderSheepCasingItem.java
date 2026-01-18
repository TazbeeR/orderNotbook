package com.example.zeszyt02.entity.DTO;

import com.example.zeszyt02.entity.SheepCasing;
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


public class OrderSheepCasingItem {

    private String origin;

    private SheepCasing sheepCasing;

    private String origin2;

    private SheepCasing sheepCasing2;

    private short quantity;

    private BigDecimal price;

    private String description;
}
