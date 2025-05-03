package ru.innopolis.attestation3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.attestation3.model.Diagnosis;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
}
