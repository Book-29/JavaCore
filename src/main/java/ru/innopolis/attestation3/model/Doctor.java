package ru.innopolis.attestation3.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "doctor", schema = "public")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "name", nullable = false)
    private String name;

@Column(name = "specialization", nullable = false)
    private String specialization;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}
