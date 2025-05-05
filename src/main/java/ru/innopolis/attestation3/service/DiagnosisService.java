package ru.innopolis.attestation3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.attestation3.dto.DiagnosisDto;
import ru.innopolis.attestation3.mapper.DiagnosisMapper;
import ru.innopolis.attestation3.model.Diagnosis;
import ru.innopolis.attestation3.repository.DiagnosisRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class DiagnosisService {


    private final DiagnosisRepository diagnosisRepository;

    private final DiagnosisMapper diagnosisMapper;



    public List<DiagnosisDto> getAllDiagnosis() {
        List<Diagnosis> diagnoses = diagnosisRepository.findAll();
        return diagnosisMapper.toDtos(diagnoses);
    }

    public DiagnosisDto saveDiagnosis(DiagnosisDto diagnosisDto) {
        Diagnosis diagnosis = diagnosisMapper.toEntity(diagnosisDto);
        Diagnosis savedDiagnosis = diagnosisRepository.save(diagnosis);
        return diagnosisMapper.toDto(savedDiagnosis);
    }

    public void deleteDiagnosisById(Long id) {
        diagnosisRepository.deleteById(id);
    }

    public DiagnosisDto getDiagnosisById(Long id) {
        Diagnosis diagnosis = diagnosisRepository.findById(id).orElseThrow();
        return diagnosisMapper.toDto(diagnosis);
    }

    public DiagnosisDto updateDiagnosis(DiagnosisDto diagnosisDto) {
        Diagnosis diagnosis = diagnosisMapper.toEntity(diagnosisDto);
        Diagnosis updatedDiagnosis = diagnosisRepository.save(diagnosis);
        return diagnosisMapper.toDto(updatedDiagnosis);
    }

}
