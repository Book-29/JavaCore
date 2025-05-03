package ru.innopolis.attestation3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.attestation3.model.Patient;
import ru.innopolis.attestation3.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {


    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);

    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatientById(id);
    }
}
