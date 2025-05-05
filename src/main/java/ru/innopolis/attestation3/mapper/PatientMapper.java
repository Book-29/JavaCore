package ru.innopolis.attestation3.mapper;

import org.springframework.stereotype.Component;
import ru.innopolis.attestation3.dto.PatientDto;
import ru.innopolis.attestation3.model.Patient;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper implements Mapper<Patient, PatientDto>{

    @Override
    public Patient toEntity(PatientDto dto) {
        return new Patient(dto.getId(), dto.getName(), null, null, false, null, null);
    }

    @Override
    public PatientDto toDto(Patient entity) {
        return new PatientDto(entity.getId(), entity.getName(), entity.getAddress());
    }

    @Override
    public List<Patient> toEntities(List<PatientDto> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<PatientDto> toDtos(List<Patient> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
