package com.example.zeszyt02.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public abstract class OrderItem {

    private String type;

    private BigDecimal price;

    private short  quantity;

    private String  description;

}

