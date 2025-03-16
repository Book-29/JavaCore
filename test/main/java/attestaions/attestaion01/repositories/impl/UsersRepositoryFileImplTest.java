package main.java.attestaions.attestaion01.repositories.impl;

import main.java.attestaions.attestaion01.model.User;
import main.java.attestaions.attestaion01.repositories.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryFileImplTest {
    private UsersRepository repository;
    private User user;

    @BeforeEach
    public void setUp() {
        repository = new UsersRepositoryFileImpl();
        repository.deleteAll(); // Очищаем репозиторий перед каждым тестом
        User user = new User("f5a8a3cb_1", LocalDateTime.now(), "noisemc_9900", "789ghs_222", "789ghs_222", "Иванов", "Иван", "Иванович", 30, true);

    }

    @Test
    public void testCreateUser() {
        repository = new UsersRepositoryFileImpl();


        repository.create(user);
         assertEquals("f5a8a3cb_1", user.getId());
         assertEquals("noisemc_9900", user.getLogin());
         assertNotNull(user);
    }

    @Test
    public void testFindAll() {
        User user = new User("f5a8a3cb_1", LocalDateTime.now(), "noisemc_9900", "789ghs_222", "789ghs_222", "Иванов", "Иван", "Иванович", 30, true);
      User user2 = new User("567890", LocalDateTime.now(), "user2", "password2", "password2", "Петров", "Петр", "Петрович", 40, true);
        repository.create(user);
        repository.create(user2);
        List<User> users = repository.findAll();
        assertEquals(2, users.size());


    }

    @Test
    public void testFindByIdThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            repository.findById("nonexistent-id");
        });
    }

    @Test
    public void testDeleteById() {
        repository = new UsersRepositoryFileImpl();
        User user = new User("f5a8a3cb_1", LocalDateTime.now(), "noisemc_9900", "789ghs_222", "789ghs_222", "Иванов", "Иван", "Иванович", 30, true);
        repository.create(user);
        assertEquals(1, repository.findAll().size());
        repository.deleteById("f5a8a3cb_1");
        assertEquals(0, repository.findAll().size());
    }





}