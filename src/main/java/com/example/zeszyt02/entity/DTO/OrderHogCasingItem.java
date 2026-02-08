package com.example.zeszyt02.entity.DTO;

import com.example.zeszyt02.entity.HogCasing;
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

public class OrderHogCasingItem extends OrderItem {

    private String origin;
    private HogCasing hogCasing;
    private String origin2;
    private HogCasing hogCasing2;

}
