package com.cenfotec.mongoapi.repository;

import com.cenfotec.mongoapi.domian.Professional;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProfessionalRepository extends MongoRepository<Professional, String> {
    public List<Professional> findByName(String name);
}
