package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.BeefCasing;
import com.example.zeszyt02.repository.BeefCasingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPABeefCasingService implements BeefCasingService {
    private final BeefCasingsRepository beefCasingsRepository;

    public JPABeefCasingService(BeefCasingsRepository beefCasingsRepository) {
        this.beefCasingsRepository = beefCasingsRepository;
    }

    @Override
    public List<BeefCasing> findAllBeefCasings() {
        return beefCasingsRepository.findAll();
    }

    @Override
    public Optional<BeefCasing> findBeefCasingById(Long id) {
        return beefCasingsRepository.findById(id);
    }

    @Override
    public void saveBeefCasing(BeefCasing beefCasing) {
        beefCasingsRepository.save(beefCasing);
    }

    @Override
    public void deleteBeefCasing(Long id) {
        beefCasingsRepository.deleteById(id);
    }

    @Override
    public void updateBeefCasing(BeefCasing beefCasing) {
        beefCasingsRepository.save(beefCasing);
    }
}
