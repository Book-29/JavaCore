package ru.innopolis.attestation3.service;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import ru.innopolis.attestation3.exception.NotFoundException;

import ru.innopolis.attestation3.mapper.PatientMapper;
import ru.innopolis.attestation3.model.Patient;
import ru.innopolis.attestation3.repository.PatientRepository;
import ru.innopolis.attestation3.dto.PatientDto;
import java.util.List;

import static ru.innopolis.attestation3.utils.ProjectErrors.PATIENT_NOT_FOUND_ERR0R;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientDto getPatientById(final Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(PATIENT_NOT_FOUND_ERR0R));
        return patientMapper.toDto(patient);
    }

    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findByIsDeletedFalse();
        return patientMapper.toDtos(patients);
    }

    public PatientDto savePatient(PatientDto patientDto) {
        Patient patient = patientMapper.toEntity(patientDto);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toDto(savedPatient);
    }

    public void deletePatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(PATIENT_NOT_FOUND_ERR0R));
        patient.setDeleted(true);
        patientRepository.save(patient);
    }




}
