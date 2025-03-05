package main.java.attestaions.attestaion01.repositories.impl;

import main.java.attestaions.attestaion01.model.User;
import main.java.attestaions.attestaion01.repositories.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryFileImplTest {
    private UsersRepository repository;
    private User user;

    @BeforeEach
    public void setUp() {
        repository = new UsersRepositoryFileImpl();
        repository.deleteAll(); // Очищаем репозиторий перед каждым тестом
    }



    @Test
    public void testFindByIdThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            repository.findById("nonexistent-id");
        });
    }




}