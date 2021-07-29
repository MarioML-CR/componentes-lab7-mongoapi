package com.cenfotec.mongoapi.service;


import com.cenfotec.mongoapi.domian.Professional;

import java.util.List;
import java.util.Optional;

public interface ProfessionalService {
    public void saveProfessional(Professional newProfessional);
    public List<Professional> getAll();
    public Optional<Professional> getById(String id);
    public Optional<Professional> update(Professional professional);
    public boolean delete(String id);
}
