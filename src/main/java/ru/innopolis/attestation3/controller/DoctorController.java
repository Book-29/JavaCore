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
import ru.innopolis.attestation3.dto.DoctorDto;
import ru.innopolis.attestation3.model.Doctor;
import ru.innopolis.attestation3.service.DoctorService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/doctor")
@Tag(name = "Доктора", description = "Контроллер для работы с докторами")
public class DoctorController {

    private final DoctorService doctorService;

    @Operation(description = "Получение списка всех докторов")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        List<DoctorDto> doctors = doctorService.getAllDoctors();
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }

    @Operation(description = "Создание нового доктора")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
        DoctorDto savedDoctor = doctorService.saveDoctor(doctorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
    }

    @Operation(description = "Удаление доктора по ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
