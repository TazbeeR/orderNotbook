package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.Spices;

import java.util.List;
import java.util.Optional;

public interface SpicesService {

    List<Spices> getSpices();
    Optional<Spices> getSpice(long id);
    void addSpice(Spices spices);
    void updateSpice(Spices spices);
    void deleteSpice(long id);
}
