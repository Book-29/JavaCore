package ru.innopolis.attestation3.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.attestation3.model.Diagnosis;
import ru.innopolis.attestation3.service.DiagnosisService;

import java.util.List;

@RestController
@RequestMapping("/api/diagnosis")
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    @GetMapping
    public List<Diagnosis> getAllDiagnosis() {
        return diagnosisService.getAllDiagnosis();
    }

    @PostMapping
    public Diagnosis createDiagnosis(@RequestBody Diagnosis diagnosis) {
        return diagnosisService.saveDiagnosis(diagnosis);
    }

    @DeleteMapping("/{id}")
    public void deleteDiagnosis(@PathVariable Long id) {
        diagnosisService.deleteDiagnosisById(id);
    }
}
