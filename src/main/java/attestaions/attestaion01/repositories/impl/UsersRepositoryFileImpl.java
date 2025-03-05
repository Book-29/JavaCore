package main.java.attestaions.attestaion01.repositories.impl;

import main.java.attestaions.attestaion01.model.User;
import main.java.attestaions.attestaion01.repositories.UsersRepository;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class UsersRepositoryFileImpl implements UsersRepository {

   private static final List<User> USERS = new ArrayList<>();
   private static final String FILE_PATH = "C:/Users/User/IdeaProjects/Innopolis/JavaCore/src/main/java/attestaions/attestaion01/users.txt";

    private  void saveUsersToFile()  {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))){
              for(User user: USERS) {
                  writer.write(mapToString(user));
                  writer.newLine(); // Добавляем новую строку после записи пользователя
              }

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private void appendUserToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(mapToString(user));
            writer.newLine(); // Добавляем новую строку после записи пользователя
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private String mapToString(User user) {
        return String.join("|",
                user.getId(),
                user.getDate().toString(),
                user.getLogin(),
                user.getPassword(),
                user.getConfirmPassword(),
                user.getSurname(),
                user.getName(),
                user.getPatronymic() != null ? user.getPatronymic(): "",
                user.getAge() != 0 ? String.valueOf(user.getAge()): "",
                Boolean.toString(user.isWorker())
        );
    }


    @Override
    public void create(User user) {
    USERS.add(user);
    appendUserToFile(user);
    }

    @Override
    public User findById(String id) {

        if (USERS.isEmpty()) {

            USERS.addAll(findAll());
        }
            return USERS.stream()
                    .filter(user -> user.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Пользователь не найден"));
       }


    @Override
    public List<User> findAll() {
        if (USERS.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
                List<User> usersFromFile = br.lines()
                        .map(line -> {
                            String[] userFields = line.split("[|]");
                            if (userFields.length >= 10) {
                                String id = userFields[0].trim();
                                LocalDateTime date = LocalDateTime.parse(userFields[1].trim());
                                String login = userFields[2].trim();
                                String password = userFields[3].trim();
                                String confirmPassword = userFields[4].trim();
                                String surname = userFields[5].trim();
                                String name = userFields[6].trim();
                                String patronymic = userFields[7].trim();
                                int age = Integer.parseInt(userFields[8].trim());
                                Boolean isWorker = Boolean.parseBoolean(userFields[9].trim());
                                return new User(id, date, login, password, confirmPassword, surname, name, patronymic, age, isWorker);

                            } else {
                                System.out.println("Ошибка в файле: некорректные данные пользователя");

                            return null;
                            }
                        })
                        .filter(user -> user != null)
                        .collect(Collectors.toList());
                USERS.addAll(usersFromFile);

                return USERS;
            } catch (IOException e) {
                throw new RuntimeException("Ошибка при чтении файла", e);
            }
        }
        return USERS;
    }

    @Override
    public void update(User user) {
        if (USERS.isEmpty()) {
            findAll();
        }
        USERS.removeIf(u -> u.getId().equals(user.getId()));
        USERS.add(user);

       saveUsersToFile();
    }

    @Override
    public void deleteById(String id) {
        if (USERS.isEmpty()) {
            findAll();

            if (USERS.removeIf(u -> u.getId().equals(id))){

             saveUsersToFile();

             } else {
                throw new NoSuchElementException("Пользователь не найден");
            }
        }
    }

    @Override
    public void deleteAll() {
        USERS.clear();
        saveUsersToFile();
    }






}
