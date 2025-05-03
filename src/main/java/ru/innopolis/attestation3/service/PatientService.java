package ru.innopolis.attestation3.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.attestation3.model.Patient;
import ru.innopolis.attestation3.repository.PatientRepository;

import java.util.List;

@Service
public class PatientService {


    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public List<Patient> getAllPatients() {
        return patientRepository.findByIsDeletedFalse();
    }
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);

    }

    public void deletePatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пациент не найден с ID" + id));

        patientRepository.save(patient);
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пациент не найден с ID" + id));
    }
}
