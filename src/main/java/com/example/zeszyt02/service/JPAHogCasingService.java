package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.HogCasing;
import com.example.zeszyt02.repository.HogCasingRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JPAHogCasingService implements HogCasingService {
    private final HogCasingRepository hogCasingRepository;

    public JPAHogCasingService(HogCasingRepository hogCasingRepository) {
        this.hogCasingRepository = hogCasingRepository;
    }


    @Override
    public List<HogCasing> getHogCasing() {
        return hogCasingRepository.findAll();
    }

    @Override
    public Optional<HogCasing> getHogCasing(long id) {
        return hogCasingRepository.findById(id);
    }

    @Override
    public void addHogCasing(HogCasing hogCasing) {
        hogCasingRepository.save(hogCasing);
    }

    @Override
    public void deleteHogCasing(long id) {
        hogCasingRepository.deleteById(id);
    }

    @Override
    public void updateHogCasing(HogCasing hogCasing) {
        hogCasingRepository.save(hogCasing);
    }

}
