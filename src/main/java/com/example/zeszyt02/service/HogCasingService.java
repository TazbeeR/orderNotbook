package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.HogCasing;

import java.util.List;
import java.util.Optional;

public interface HogCasingService {

    List<HogCasing> getHogCasing();
    Optional<HogCasing> getHogCasing(long id);
    void addHogCasing (HogCasing hogCasing);
    void deleteHogCasing(long id);
    void updateHogCasing(HogCasing hogCasing);
}
