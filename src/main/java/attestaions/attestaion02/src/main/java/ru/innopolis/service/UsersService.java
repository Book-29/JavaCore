package ru.innopolis.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import ru.innopolis.repository.UsersRepository;


import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor


public class UsersService {
    private final UsersRepository usersRepository;






}
