package ru.innopolis.attestation3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.attestation3.dto.DoctorDto;
import ru.innopolis.attestation3.mapper.DoctorMapper;
import ru.innopolis.attestation3.model.Doctor;
import ru.innopolis.attestation3.repository.DoctorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {


    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctorMapper.toDtos(doctors);
    }

    public DoctorDto saveDoctor(DoctorDto doctorDto) {
        Doctor doctor = doctorMapper.toEntity(doctorDto);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toDto(savedDoctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public DoctorDto getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        return doctorMapper.toDto(doctor);
    }

}
