package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс, представляющий пользователя банковской системы
 * @author DMITRY ARININ
 * @version 1.0
 */
public class User {
    /**
     * Строковое поле пасспорт
     */
    private String passport;

    /**
     * Строковое поле имя пользователя
     */
    private String username;

    /**
     * Конструктор для создания объекта пользователя
     * @param passport Паспортные данные пользователя
     * @param username Имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Получает паспортные данные пользователя
     * @return Паспортные данные пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает паспортные данные пользователя
     * @param passport Паспортные данные пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Получает имя пользователя
     * @return Имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает имя пользователя
     * @param username Имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределение метода equals для сравнения объектов User
     * @param o Объект для сравнения
     * @return {@code true}, если объекты равны, {@code false} в противном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределение метода hashCode для вычисления хеш-кода объекта User
     * @return Хеш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
