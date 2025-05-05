package ru.innopolis.attestation3.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "diagnosis", schema = "public")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code",nullable = false)
    private String code;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;


}
