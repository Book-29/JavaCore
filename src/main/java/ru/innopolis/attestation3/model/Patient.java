package ru.innopolis.attestation3.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "patients", schema = "public")
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthData;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isDeleted=" + isDeleted +
                ", birthData=" + birthData +
                ", appointments=" + appointments +
                '}';
    }
}
