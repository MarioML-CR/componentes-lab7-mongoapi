package com.cenfotec.mongoapi.service;

import com.cenfotec.mongoapi.domian.Professional;
import com.cenfotec.mongoapi.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalServiceImpl implements ProfessionalService{

    @Autowired
    ProfessionalRepository professionalRepository;

    @Override
    public void saveProfessional(Professional newProfessional) {
        professionalRepository.save(newProfessional);
    }

    @Override
    public List getAll() {
        return professionalRepository.findAll();
    }

    @Override
    public Optional<Professional> getById(String id) {
        return professionalRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<Professional> update(Professional professional) {
        Optional<Professional> result = professionalRepository.findById(professional.getId());
        if (result.isPresent()) {
            return Optional.of(professionalRepository.save(professional));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(String id) {
        Optional<Professional> result = professionalRepository.findById(id);
        if (result.isPresent()) {
            professionalRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
