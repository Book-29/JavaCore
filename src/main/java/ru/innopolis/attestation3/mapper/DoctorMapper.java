package ru.innopolis.attestation3.mapper;

import org.springframework.stereotype.Component;
import ru.innopolis.attestation3.dto.DoctorDto;
import ru.innopolis.attestation3.model.Doctor;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorMapper implements Mapper<Doctor, DoctorDto> {
    @Override
    public Doctor toEntity(DoctorDto dto) {
        return new Doctor(dto.getId(), dto.getName(), dto.getSpecialization(), null);
    }

    @Override
    public DoctorDto toDto(Doctor entity) {
        return new DoctorDto(entity.getId(), entity.getName(), entity.getSpecialization());
    }

    @Override
    public List<Doctor> toEntities(List<DoctorDto> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<DoctorDto> toDtos(List<Doctor> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
