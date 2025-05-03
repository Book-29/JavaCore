package ru.innopolis.attestation3.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisDto {

    private Long id;
    private String code;
    private String description;

    @Override
    public String toString() {
        return "DiagnosisDto{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
