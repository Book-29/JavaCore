package ru.innopolis.attestation3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.attestation3.model.Diagnosis;
import ru.innopolis.attestation3.repository.DiagnosisRepository;

import java.util.List;

@Service
public class DiagnosisService {


    private final DiagnosisRepository diagnosisRepository;

    @Autowired
    public DiagnosisService(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }
    public List<Diagnosis> getAllDiagnosis() {
        return diagnosisRepository.findAll();
    }

    public Diagnosis saveDiagnosis(Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }

    public void deleteDiagnosisById(Long id) {
        Diagnosis diagnosis = diagnosisRepository.findById(id).orElseThrow();

        diagnosisRepository.save(diagnosis);
    }

    public Diagnosis getDiagnosisById(Long id) {
        return diagnosisRepository.findById(id).orElseThrow();
    }

    public Diagnosis updateDiagnosis(Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }

}
