package ru.innopolis.jpademo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ru.innopolis.jpademo.model.Users;

import java.time.LocalDateTime;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {


}
