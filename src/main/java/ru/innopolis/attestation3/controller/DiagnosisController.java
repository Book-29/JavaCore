package ru.innopolis.attestation3.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.attestation3.dto.DiagnosisDto;
import ru.innopolis.attestation3.model.Diagnosis;
import ru.innopolis.attestation3.service.DiagnosisService;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/diagnosis")
@Tag(name = "Диагнозы", description = "Контроллер для работы с диагнозами")
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @Operation(description = "Получение списка всех диагнозов")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiagnosisDto>> getAllDiagnosis() {
        List<DiagnosisDto> diagnoses = diagnosisService.getAllDiagnosis();
        return ResponseEntity.status(HttpStatus.OK).body(diagnoses);
    }

    @Operation(description = "Создание нового диагноза")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiagnosisDto> createDiagnosis(@RequestBody DiagnosisDto diagnosisDto) {
        DiagnosisDto savedDiagnosis = diagnosisService.saveDiagnosis(diagnosisDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDiagnosis);
    }

    @Operation(description = "Удаление диагноза по ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiagnosis(@PathVariable Long id) {
        diagnosisService.deleteDiagnosisById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}