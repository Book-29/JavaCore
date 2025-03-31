package ru.innopolis.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ru.innopolis.model.Users;

import java.time.LocalDateTime;
import java.util.List;

public interface UsersRepository  {
    Users findById(Long id);



}
