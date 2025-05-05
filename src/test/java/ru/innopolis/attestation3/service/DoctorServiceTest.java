package ru.innopolis.attestation3.service;

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
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.innopolis.attestation3.dto.DoctorDto;
import ru.innopolis.attestation3.mapper.DoctorMapper;
import ru.innopolis.attestation3.model.Doctor;
import ru.innopolis.attestation3.repository.DoctorRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)

public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private DoctorMapper doctorMapper;

    @InjectMocks
    private DoctorService doctorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllDoctors() {
        Doctor doctor = new Doctor();
        DoctorDto doctorDto = new DoctorDto();
        when(doctorRepository.findAll()).thenReturn(Arrays.asList(doctor));
        when(doctorMapper.toDtos(anyList())).thenReturn(Arrays.asList(doctorDto));

        List<DoctorDto> result = doctorService.getAllDoctors();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(doctorRepository, times(1)).findAll();
        verify(doctorMapper, times(1)).toDtos(anyList());
    }

    @Test
    public void testSaveDoctor() {
        Doctor doctor = new Doctor();
        DoctorDto doctorDto = new DoctorDto();
        when(doctorMapper.toEntity(any(DoctorDto.class))).thenReturn(doctor);
        when(doctorRepository.save(any(Doctor.class))).thenReturn(doctor);
        when(doctorMapper.toDto(any(Doctor.class))).thenReturn(doctorDto);

        DoctorDto result = doctorService.saveDoctor(doctorDto);

        assertNotNull(result);
        verify(doctorMapper, times(1)).toEntity(any(DoctorDto.class));
        verify(doctorRepository, times(1)).save(any(Doctor.class));
        verify(doctorMapper, times(1)).toDto(any(Doctor.class));
    }

    @Test
    public void testDeleteDoctor() {
        Long doctorId = 1L;

        doctorService.deleteDoctor(doctorId);

        verify(doctorRepository, times(1)).deleteById(doctorId);
    }

    @Test
    public void testGetDoctorById() {
        Long doctorId = 1L;
        Doctor doctor = new Doctor();
        DoctorDto doctorDto = new DoctorDto();
        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));
        when(doctorMapper.toDto(any(Doctor.class))).thenReturn(doctorDto);

        DoctorDto result = doctorService.getDoctorById(doctorId);

        assertNotNull(result);
        verify(doctorRepository, times(1)).findById(doctorId);
        verify(doctorMapper, times(1)).toDto(any(Doctor.class));
    }
}