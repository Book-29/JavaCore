package ru.innopolis.attestation3.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.attestation3.dto.AppointmentDto;
import ru.innopolis.attestation3.model.Appointment;
import ru.innopolis.attestation3.service.AppointmentService;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/appointment")
@Tag(name = "Назначения", description = "Контроллер для работы с назначениями")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Operation(description = "Получение списка всех назначений")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        List<AppointmentDto> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.status(HttpStatus.OK).body(appointments);
    }

    @Operation(description = "Создание нового назначения")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        AppointmentDto savedAppointment = appointmentService.saveAppointment(appointmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
    }

    @Operation(description = "Удаление назначения по ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(description = "Получение назначения по ID")
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long id) {
        AppointmentDto appointmentDto = appointmentService.getAppointmentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentDto);
    }
}
