package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.SheepCasing;

import java.util.List;
import java.util.Optional;

public interface SheepCasingService {

    List<SheepCasing> getSheepCasings();
    Optional<SheepCasing> getSheepCasing(long id);
    void addSheepCasing (SheepCasing sheepCasing);
    void deleteSheepCasing(long id);
    void updateSheepCasing(SheepCasing sheepCasing);
}
