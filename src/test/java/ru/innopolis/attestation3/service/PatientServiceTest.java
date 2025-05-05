package ru.innopolis.attestation3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.innopolis.attestation3.dto.PatientDto;
import ru.innopolis.attestation3.mapper.PatientMapper;
import ru.innopolis.attestation3.model.Patient;
import ru.innopolis.attestation3.repository.PatientRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)

class PatientServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(PatientServiceTest.class);

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientMapper patientMapper;

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
        PatientDto patientDto1 = new PatientDto(1L, "John Doe", "123 Main St");
        PatientDto patientDto2 = new PatientDto(2L, "Jane Doe", "456 Main St");

        when(patientRepository.findByIsDeletedFalse()).thenReturn(Arrays.asList(patient1, patient2));
        when(patientMapper.toDtos(Arrays.asList(patient1, patient2))).thenReturn(Arrays.asList(patientDto1, patientDto2));

        // Act
        List<PatientDto> patientDtos = patientService.getAllPatients();

        // Assert
        assertNotNull(patientDtos);
        assertEquals(2, patientDtos.size());
        verify(patientRepository, times(1)).findByIsDeletedFalse();
        verify(patientMapper, times(1)).toDtos(Arrays.asList(patient1, patient2));

        // Log output
        logger.info("Тест getAllPatients passed. Количество пациентов: {}", patientDtos.size());
    }
}