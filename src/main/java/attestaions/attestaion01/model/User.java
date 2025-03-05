package main.java.attestaions.attestaion01.model;
//- id типа String – гарантированно уникальный ID пользователя. Состоит из
//букв и цифр.
//- дата LocalDateTime добавления в систему, по умолчанию сегодня,
//формат: дата и время;
//- login типа String, не может быть только из цифр, содержит буквы,
//цифры, знак подчеркивания, меньше 20 символов
//- password и confirmPassword типа String, одинаковые, не может быть
//только из букв, содержит буквы, цифры, знак подчеркивания, меньше 20
//символов
//- фамилия - строка, состоит только из букв;
//- имя - строка, состоит только из букв;
//- отчество - строка, состоит только из букв, может отсутствовать;
//- возраст – целое число, может отсутствовать;
//- isWorker – является ли сотрудником предприятия, по умолчанию false.


import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private String id;
    private LocalDateTime date;
    private String login;
    private String password;
    private String confirmPassword;
    private String surname;
    private String name;
    private String patronymic;
    private int age;
    private boolean isWorker;


    public User(String id, LocalDateTime date, String login, String password, String confirmPassword, String surname, String name, String patronymic, int age, boolean isWorker) {
        this.id = id;
        this.date = LocalDateTime.now();
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
        this.isWorker = isWorker;
    }
    public User(String id, String login, String surname, String name, String patronymic) {

        this.id = id;
        this.login = login;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[_]).{1,20}$")) {
        this.id = id;
        } else {
            throw new IllegalArgumentException("ID может состоять только из букв и цифр");
        }
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login.length() > 20) {
            throw new IllegalArgumentException("Логин не может быть больше 20 символов");
        } else if (login.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[_]).{1,20}$")) {
                this.login = login;

            } else {
                throw new IllegalArgumentException("Логин может состоять только из букв, цифр и знака подчеркивания");

            }
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() > 20) {
            throw new IllegalArgumentException("Пароль не может быть больше 20 символов");
        } else if (password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[_]).{1,20}$")) {
        this.password = password;
        } else {
        throw new IllegalArgumentException("Пароль может состоять только из букв, цифр и знака подчеркивания");}
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        if (!confirmPassword.equals(password)) {
            throw new IllegalArgumentException("Пароли должны совпадать");
        } else {
            this.confirmPassword = confirmPassword;
        }
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {
        if (surname.matches("[a-zA-Zа-яА-Я]+")){
        this.surname = surname;
        } else {
          throw new IllegalArgumentException("Фамилия может состоять только из букв");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.matches("[a-zA-Zа-яА-Я]+")){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя может состоять только из букв");
        }

    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        if (patronymic == null || patronymic.matches("[a-zA-Zа-яА-Я]+")){
            this.patronymic = patronymic;
        } else {
            throw new IllegalArgumentException("Отчество может состоять только из букв");
        }


    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }else {
            throw new IllegalArgumentException("Возраст должен быть целым числом");
        }

    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && isWorker == user.isWorker && Objects.equals(id, user.id) && Objects.equals(date, user.date) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(confirmPassword, user.confirmPassword) && Objects.equals(surname, user.surname) && Objects.equals(name, user.name) && Objects.equals(patronymic, user.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, login, password, confirmPassword, surname, name, patronymic, age, isWorker);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", isWorker=" + isWorker +
                '}';
    }
}

