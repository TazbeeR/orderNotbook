package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.BeefCasing;

import java.util.List;
import java.util.Optional;

public interface BeefCasingService {

    List<BeefCasing> findAllBeefCasings();
    Optional<BeefCasing> findBeefCasingById(Long id);
    void saveBeefCasing(BeefCasing beefCasing);
    void deleteBeefCasing(Long id);
    void updateBeefCasing(BeefCasing beefCasing);
}
