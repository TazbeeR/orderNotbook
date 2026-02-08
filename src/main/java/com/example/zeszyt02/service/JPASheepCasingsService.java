package com.example.zeszyt02.service;

import com.example.zeszyt02.entity.SheepCasing;
import com.example.zeszyt02.repository.SheepCasingRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JPASheepCasingsService implements SheepCasingService {
    private final SheepCasingRepository sheepCasingsRepository;

    public JPASheepCasingsService(SheepCasingRepository sheepCasingsRepository) {
        this.sheepCasingsRepository = sheepCasingsRepository;
    }

    @Override
    public List<SheepCasing> getSheepCasings() {return sheepCasingsRepository.findAll(); }

    @Override
    public Optional<SheepCasing> getSheepCasing(long id) {return sheepCasingsRepository.findById(id);
    }

    @Override
    public SheepCasing addSheepCasing(SheepCasing sheepCasing)  {
        return sheepCasingsRepository.save(sheepCasing);
    }

    @Override
    public void deleteSheepCasing(long id) { sheepCasingsRepository.deleteById(id);}

    @Override
    public void updateSheepCasing(SheepCasing sheepCasing) {sheepCasingsRepository.save(sheepCasing);}

}
