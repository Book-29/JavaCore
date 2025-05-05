package ru.innopolis.attestation3.mapper;

import org.springframework.stereotype.Component;
import ru.innopolis.attestation3.dto.DiagnosisDto;
import ru.innopolis.attestation3.model.Diagnosis;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiagnosisMapper implements Mapper<Diagnosis, DiagnosisDto>{

    @Override
    public Diagnosis toEntity(DiagnosisDto dto) {
        return new Diagnosis(dto.getId(), dto.getCode(), dto.getDescription(), false);
    }

    @Override
    public DiagnosisDto toDto(Diagnosis entity) {
        return new DiagnosisDto(entity.getId(), entity.getCode(), entity.getDescription());
    }

    @Override
    public List<Diagnosis> toEntities(List<DiagnosisDto> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<DiagnosisDto> toDtos(List<Diagnosis> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
