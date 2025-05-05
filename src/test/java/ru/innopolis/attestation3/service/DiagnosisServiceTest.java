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
import ru.innopolis.attestation3.dto.DiagnosisDto;
import ru.innopolis.attestation3.mapper.DiagnosisMapper;
import ru.innopolis.attestation3.model.Diagnosis;
import ru.innopolis.attestation3.repository.DiagnosisRepository;
@SpringBootTest
@ExtendWith(SpringExtension.class)

@ExtendWith(MockitoExtension.class)
class DiagnosisServiceTest {
    @Mock
    private DiagnosisRepository diagnosisRepository;

    @Mock
    private DiagnosisMapper diagnosisMapper;

    @InjectMocks
    private DiagnosisService diagnosisService;

    @Test
    public void testGetAllDiagnosis() {
        Diagnosis diagnosis = new Diagnosis();
        DiagnosisDto diagnosisDto = new DiagnosisDto();
        when(diagnosisRepository.findAll()).thenReturn(Arrays.asList(diagnosis));
        when(diagnosisMapper.toDtos(anyList())).thenReturn(Arrays.asList(diagnosisDto));

        List<DiagnosisDto> result = diagnosisService.getAllDiagnosis();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(diagnosisRepository, times(1)).findAll();
        verify(diagnosisMapper, times(1)).toDtos(anyList());
    }

    @Test
    public void testSaveDiagnosis() {
        Diagnosis diagnosis = new Diagnosis();
        DiagnosisDto diagnosisDto = new DiagnosisDto();
        when(diagnosisMapper.toEntity(any(DiagnosisDto.class))).thenReturn(diagnosis);
        when(diagnosisRepository.save(any(Diagnosis.class))).thenReturn(diagnosis);
        when(diagnosisMapper.toDto(any(Diagnosis.class))).thenReturn(diagnosisDto);

        DiagnosisDto result = diagnosisService.saveDiagnosis(diagnosisDto);

        assertNotNull(result);
        verify(diagnosisMapper, times(1)).toEntity(any(DiagnosisDto.class));
        verify(diagnosisRepository, times(1)).save(any(Diagnosis.class));
        verify(diagnosisMapper, times(1)).toDto(any(Diagnosis.class));
    }

    @Test
    public void testDeleteDiagnosisById() {
        Long diagnosisId = 1L;

        diagnosisService.deleteDiagnosisById(diagnosisId);

        verify(diagnosisRepository, times(1)).deleteById(diagnosisId);
    }

    @Test
    public void testGetDiagnosisById() {
        Long diagnosisId = 1L;
        Diagnosis diagnosis = new Diagnosis();
        DiagnosisDto diagnosisDto = new DiagnosisDto();
        when(diagnosisRepository.findById(diagnosisId)).thenReturn(Optional.of(diagnosis));
        when(diagnosisMapper.toDto(any(Diagnosis.class))).thenReturn(diagnosisDto);

        DiagnosisDto result = diagnosisService.getDiagnosisById(diagnosisId);

        assertNotNull(result);
        verify(diagnosisRepository, times(1)).findById(diagnosisId);
        verify(diagnosisMapper, times(1)).toDto(any(Diagnosis.class));
    }

    @Test
    public void testUpdateDiagnosis() {
        Diagnosis diagnosis = new Diagnosis();
        DiagnosisDto diagnosisDto = new DiagnosisDto();
        when(diagnosisMapper.toEntity(any(DiagnosisDto.class))).thenReturn(diagnosis);
        when(diagnosisRepository.save(any(Diagnosis.class))).thenReturn(diagnosis);
        when(diagnosisMapper.toDto(any(Diagnosis.class))).thenReturn(diagnosisDto);

        DiagnosisDto result = diagnosisService.updateDiagnosis(diagnosisDto);

        assertNotNull(result);
        verify(diagnosisMapper, times(1)).toEntity(any(DiagnosisDto.class));
        verify(diagnosisRepository, times(1)).save(any(Diagnosis.class));
        verify(diagnosisMapper, times(1)).toDto(any(Diagnosis.class));
    }

}