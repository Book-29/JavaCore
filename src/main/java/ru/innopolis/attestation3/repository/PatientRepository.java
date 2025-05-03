package ru.innopolis.attestation3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.attestation3.model.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByIsDeletedFalse();
}
