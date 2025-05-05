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
import ru.innopolis.attestation3.dto.PatientDto;
import ru.innopolis.attestation3.model.Patient;
import ru.innopolis.attestation3.service.PatientService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/patient")
@Tag(name = "Пациенты",
        description = "Контроллер для работы с пациентами")

public class PatientController {
    private  PatientService patientService;

    @Operation(description = "получение пациента по ID")
    @RequestMapping(value = "/getPatient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDto> getOnePatient(@RequestParam(value = "id") Long id){
    return ResponseEntity.status(HttpStatus.OK)
            .body(patientService.getPatientById(id));
    }
    @Operation(description = "получение списка пациентов")
    @RequestMapping(value = "/list", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PatientDto>> listPatient(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(patientService.getAllPatients());
    }

    @Operation(description = "создание нового пациента")
    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDto> create(@RequestBody PatientDto newPatientDto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(patientService.savePatient(newPatientDto));
    }



    @Operation(description = "удаление пациента по ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatientById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
