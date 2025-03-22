package main.java.homeworks.homework016.src.main.java.repositories.impl;

import main.java.homeworks.homework016.src.main.java.model.User;
import main.java.homeworks.homework016.src.main.java.repositories.UsersRepository;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class UsersRepositoryFileImpl implements UsersRepository {

   private static final List<User> USERS = new ArrayList<>();
   private static final String FILE_PATH = "C:/Users/User/IdeaProjects/Innopolis/JavaCore/src/main/java/homeworks/homework016/src/main/java/resources/users.txt";

    private  void saveUsersToFile()  {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))){
              for(User user: USERS) {
                  writer.write(user.toString());
                  writer.newLine(); // Добавляем новую строку после записи пользователя
              }

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private void appendUserToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(user.toString());
            writer.newLine(); // Добавляем новую строку после записи пользователя
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
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
                        .map(User::new)
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
            }
        boolean removed = USERS.removeIf(user -> user.getId()!=null && user.getId().equals(id));

            if (removed){

             saveUsersToFile();

             } else {
                throw new NoSuchElementException("Пользователь не найден");
            }
    }

    @Override
    public void deleteAll() {
        USERS.clear();
        saveUsersToFile();
    }






}
