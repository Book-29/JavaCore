package ru.innopolis.attestation3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.attestation3.model.Appointment;
import ru.innopolis.attestation3.repository.AppointmentRepository;

import java.util.List;

@Service
public class AppointmentService {



    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);


    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).get();
    }


}
