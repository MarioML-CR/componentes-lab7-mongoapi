package com.cenfotec.mongoapi.controller;

import com.cenfotec.mongoapi.domian.Professional;
import com.cenfotec.mongoapi.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professional")
public class ProfessionalController {
    @Autowired
    private ProfessionalService profesionalService;

    @PostMapping
    public ResponseEntity<String> addProfessional(@RequestBody Professional profesional) {
        profesionalService.saveProfessional(profesional);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public List getAll() {
        return profesionalService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Professional> findById(@PathVariable String id) {
        Optional<Professional> result = profesionalService.getById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping
    public ResponseEntity<Professional> update (@RequestBody Professional professional) {
        Optional<Professional> result = profesionalService.update(professional);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Professional> delete(@PathVariable("id") String id) {
        if (profesionalService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
