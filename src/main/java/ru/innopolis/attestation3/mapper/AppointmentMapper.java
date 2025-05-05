package ru.innopolis.attestation3.mapper;

import org.springframework.stereotype.Component;
import ru.innopolis.attestation3.dto.AppointmentDto;
import ru.innopolis.attestation3.model.Appointment;
import ru.innopolis.attestation3.model.Doctor;
import ru.innopolis.attestation3.model.Patient;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppointmentMapper implements Mapper<Appointment, AppointmentDto>{
    @Override
    public Appointment toEntity(AppointmentDto dto) {
        // Создаем объекты-заглушки для Doctor и Patient, используя только их ID
        Doctor doctor = new Doctor();
        doctor.setId(dto.getDoctorId());

        Patient patient = new Patient();
        patient.setId(dto.getPatientId());

        // Создаем объект Appointment, используя заглушки
        return new Appointment(dto.getId(), patient, doctor, null);


    }

    @Override
    public AppointmentDto toDto(Appointment entity) {
        return new AppointmentDto(
                entity.getId(),
                entity.getDoctor().getId(),
                entity.getPatient().getId(),
                entity.getDiagnosis().getId());
    }

    @Override
    public List<Appointment> toEntities(List<AppointmentDto> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDto> toDtos(List<Appointment> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
