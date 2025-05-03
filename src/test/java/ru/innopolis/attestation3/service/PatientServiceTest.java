package ru.innopolis.attestation3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.innopolis.attestation3.model.Patient;
import ru.innopolis.attestation3.repository.PatientRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PatientServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(PatientServiceTest.class);

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllPatients() {
        // Arrange
        Patient patient1 = new Patient(1L, "John Doe", "123 Main St", "555-555-5555", false, null, null);
        Patient patient2 = new Patient(2L, "Jane Doe", "456 Main St", "555-555-5556", false, null, null);
        when(patientRepository.findByIsDeletedFalse()).thenReturn(Arrays.asList(patient1, patient2));

        // Act
        List<Patient> patients = patientService.getAllPatients();

        // Assert
        assertNotNull(patients);
        assertEquals(2, patients.size());
        verify(patientRepository, times(1)).findByIsDeletedFalse();

        // Log output
        System.out.println("Test getAllPatients passed. Number of patients: " + patients.size());

        // Log output

        logger.info("Тест getAllPatients passed. Количество пациентов: {}", patients.size());
    }
}