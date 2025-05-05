package ru.innopolis.attestation3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.attestation3.dto.AppointmentDto;
import ru.innopolis.attestation3.mapper.AppointmentMapper;
import ru.innopolis.attestation3.model.Appointment;
import ru.innopolis.attestation3.repository.AppointmentRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class AppointmentService {



    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;


    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointmentMapper.toDtos(appointments);
    }

    public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = appointmentMapper.toEntity(appointmentDto);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.toDto(savedAppointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public AppointmentDto getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow();
        return appointmentMapper.toDto(appointment);
    }


}
