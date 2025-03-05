package main.java.attestaions.attestaion01;

import main.java.attestaions.attestaion01.repositories.impl.UsersRepositoryFileImpl;
import main.java.attestaions.attestaion01.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        UsersRepositoryFileImpl usersRepository = new UsersRepositoryFileImpl();

        List<User> allUsers = usersRepository.findAll();
        System.out.println("Все пользователи: " + allUsers);


        try {
            User foundUser = usersRepository.findById("f5a8a3cb_1");

            System.out.println("Пользователь найден: " + foundUser);
        } catch (Exception e) {
            System.out.println("Пользователь не найден.");
        }

        usersRepository.deleteById("f5a8a3cb_3");
        System.out.println("Пользователь удален");
        usersRepository.deleteAll();
        System.out.println("Все пользователи удалены");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные пользователя:");
        String input = scanner.nextLine();

        String[] values = input.split("\\|");

        User user = new User(values[0], LocalDateTime.parse(values[1]), values[2], values[3], values[4], values[5], values[6], values[7], Integer.parseInt(values[8]), Boolean.parseBoolean(values[9]));
        user.setId(values[0]);
        user.setDate(LocalDateTime.parse(values[1]));
        user.setLogin(values[2]);
        user.setPassword(values[3]);
        user.setConfirmPassword(values[4]);
        user.setSurname(values[5]);
        user.setName(values[6]);
        user.setPatronymic(values[7]);
        user.setAge(Integer.parseInt(values[8]));
        user.setWorker(Boolean.parseBoolean(values[9]));



        usersRepository.create(user);

        System.out.println("Пользователь создан: " + user);


        usersRepository.update(user);

        System.out.println("Пользователь обновлен: " + user);









    }
}