package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.Additive;

import java.util.List;
import java.util.Optional;

public interface AdditiveService {

    List<Additive> findAllAdditives();
    Optional<Additive> findAdditiveById(Long id);
    void saveAdditive(Additive additive);
    void deleteAdditive(Long id);
    void updateAdditive(Additive additive);
}
