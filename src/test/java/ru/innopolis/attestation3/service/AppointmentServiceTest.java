package ru.innopolis.attestation3.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.innopolis.attestation3.dto.AppointmentDto;
import ru.innopolis.attestation3.mapper.AppointmentMapper;
import ru.innopolis.attestation3.model.Appointment;
import ru.innopolis.attestation3.repository.AppointmentRepository;
@SpringBootTest
@ExtendWith(SpringExtension.class)

@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private AppointmentMapper appointmentMapper;

    @InjectMocks
    private AppointmentService appointmentService;

    @Test
    public void testGetAllAppointments() {
        Appointment appointment = new Appointment();
        AppointmentDto appointmentDto = new AppointmentDto();
        when(appointmentRepository.findAll()).thenReturn(Arrays.asList(appointment));
        when(appointmentMapper.toDtos(anyList())).thenReturn(Arrays.asList(appointmentDto));

        List<AppointmentDto> result = appointmentService.getAllAppointments();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(appointmentRepository, times(1)).findAll();
        verify(appointmentMapper, times(1)).toDtos(anyList());
    }

    @Test
    public void testSaveAppointment() {
        Appointment appointment = new Appointment();
        AppointmentDto appointmentDto = new AppointmentDto();
        when(appointmentMapper.toEntity(any(AppointmentDto.class))).thenReturn(appointment);
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);
        when(appointmentMapper.toDto(any(Appointment.class))).thenReturn(appointmentDto);

        AppointmentDto result = appointmentService.saveAppointment(appointmentDto);

        assertNotNull(result);
        verify(appointmentMapper, times(1)).toEntity(any(AppointmentDto.class));
        verify(appointmentRepository, times(1)).save(any(Appointment.class));
        verify(appointmentMapper, times(1)).toDto(any(Appointment.class));
    }

    @Test
    public void testDeleteAppointment() {
        Long appointmentId = 1L;

        appointmentService.deleteAppointment(appointmentId);

        verify(appointmentRepository, times(1)).deleteById(appointmentId);
    }

    @Test
    public void testGetAppointmentById() {
        Long appointmentId = 1L;
        Appointment appointment = new Appointment();
        AppointmentDto appointmentDto = new AppointmentDto();
        when(appointmentRepository.findById(appointmentId)).thenReturn(Optional.of(appointment));
        when(appointmentMapper.toDto(any(Appointment.class))).thenReturn(appointmentDto);

        AppointmentDto result = appointmentService.getAppointmentById(appointmentId);

        assertNotNull(result);
        verify(appointmentRepository, times(1)).findById(appointmentId);
        verify(appointmentMapper, times(1)).toDto(any(Appointment.class));
    }
}