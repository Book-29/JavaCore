package ru.innopolis.jpademo.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import ru.innopolis.jpademo.model.Users;
import ru.innopolis.jpademo.repository.UsersRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor


public class UsersService {
    private final UsersRepository usersRepository;


    public Users getUser(Long id){
        return usersRepository.findById(id)
                .orElseThrow();
    }

    public List<Users> getUsers(){
        return usersRepository.findAll();
    }
    public void deleteAllUser(){

        usersRepository.deleteAll();
    }



}
