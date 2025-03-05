package main.java.attestaions.attestaion01.repositories;

//Интерфейс UsersRepository со следующими абстрактными методами:
//        - Метод void create(User user) – создание пользователя и запись его в
//файл;
//- Метод User findById(String id) — поиск пользователя в файле по
//        идентификатору;
//- Метод List<User> findAll() - выгрузка всех пользователей из файла;
//- Метод void update(User user) — обновление полей существующего в
//файле пользователя;
//- Метод void deleteById(String id) — удаление пользователя по
//идентификатору.
//- Метод void deleteAll() — удаление всех пользователей.


import main.java.attestaions.attestaion01.model.User;

import java.util.List;

public interface UsersRepository {
     void create(User user);
    User findById(String id);
    List<User> findAll();
    void update(User user);
    void deleteById(String id);
    void deleteAll();


}
