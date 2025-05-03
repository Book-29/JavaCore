package ru.innopolis.attestation3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.attestation3.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
