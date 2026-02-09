package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.Additive;
import com.example.zeszyt02.repository.AdditivesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPAAdditiveService implements AdditiveService{
    private final AdditivesRepository additivesRepository;

    public JPAAdditiveService(AdditivesRepository additivesRepository) {
        this.additivesRepository = additivesRepository;
    }

    @Override
    public List<Additive> findAllAdditives() {
        return additivesRepository.findAll();
    }

    @Override
    public Optional<Additive> findAdditiveById(Long id) {
        return additivesRepository.findById(id);
    }

    @Override
    public void saveAdditive(Additive additive) {
        additivesRepository.save(additive);
    }

    @Override
    public void deleteAdditive(Long id) {
        additivesRepository.deleteById(id);
    }

    @Override
    public void updateAdditive(Additive additive) {
        additivesRepository.save(additive);
    }
}
