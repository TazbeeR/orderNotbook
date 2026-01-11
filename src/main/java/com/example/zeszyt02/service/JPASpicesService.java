package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.Spices;
import com.example.zeszyt02.repository.SpicesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPASpicesService implements SpicesService{
    private final SpicesRepository spicesRepository;

    public JPASpicesService(SpicesRepository spicesRepository) {
        this.spicesRepository = spicesRepository;
    }

    @Override
    public List<Spices> getSpices() {
        return spicesRepository.findAll();
    }

    @Override
    public Optional<Spices> getSpice(long id) {
        return spicesRepository.findById(id);
    }

    @Override
    public void addSpice(Spices spices) {
        spicesRepository.save(spices);
    }

    @Override
    public void deleteSpice(long id) {
        spicesRepository.deleteById(id);
    }

    @Override
    public void updateSpice(Spices spices) {
        spicesRepository.save(spices);
    }
}
