package main.java.attestaions.attestaion01.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void setId() {
        User user = new User("login", "noisemc_9900", "surname",   "name","patronymic");
        assertThrows(IllegalArgumentException.class, () -> {
            user.setId(" ");
        });
    }

    @Test
    void getId() {
        User user = new User("login", "noisemc_9900", "surname",  "name","patronymic");
    }

    @Test
    void getLogin() {

        User user = new User("login", "noisemc_9900", "surname",  "name","patronymic");
        assertEquals("noisemc_9900", user.getLogin());

    }

    @Test
    void setLogin() {
        User user = new User("login", "noisemc_9900", "surname",  "name","patronymic");
        user.setLogin("noisemc_9900");
        assertEquals("noisemc_9900", user.getLogin());
        assertThrows(IllegalArgumentException.class, () -> {
            user.setLogin("123456");
        });
    }

    @Test
    void getName() {
        User user = new User("login", "noisemc_9900", "surname",  "name","patronymic");
        assertEquals("name", user.getName());
    }

    @Test
    void setName() {
        User user = new User("login", "noisemc_9900", "surname",  "name","patronymic");
        user.setName("name");
    }

    @Test
    void getSurname() {
        User user = new User("login", "noisemc_9900", "surname",  "name","patronymic");
        assertEquals("surname", user.getSurname());
    }

    @Test
    void setSurname() {
        User user = new User("login", "noisemc_9900", "surname",  "name","patronymic");
        user.setSurname("surname");
        assertEquals("surname", user.getSurname());
    }

    @Test
    void getPatronymic() {
    }
}