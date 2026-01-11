package com.example.zeszyt02.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hogcasings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HogCasing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @NotEmpty
//    @Pattern(regexp = "[0-9][0-9]/[0-9][0-9][A-Z][A-Z]")
    private String caliber;

}
