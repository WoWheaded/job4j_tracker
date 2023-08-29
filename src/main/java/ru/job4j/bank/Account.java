package ru.job4j.bank;

import java.util.Objects;

/**
 *  Класс, представляющий банковский счет с реквизитами и балансом.
 *  @author DMITRY ARININ
 *  @version 1.0
 */
public class Account {
    /**
     * Строковое поле реквизит
     */
    private String requisite;

    /**
     * Дробное число для поля баланса
     */
    private double balance;

    /**
     * Конструктор для создания объекта Account с указанными реквизитами и начальным балансом
     * @param requisite Реквизиты банковского счета
     * @param balance   Начальный баланс банковского счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Получает реквизиты банковского счета
     * @return Реквизиты банковского счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает реквизиты банковского счета
     * @param requisite Реквизиты банковского счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Получает текущий баланс банковского счета
     * @return Текущий баланс банковского счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает баланс банковского счета
     * @param balance Новый баланс банковского счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение метода equals для сравнения объектов Account
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределение метода hashCode для вычисления хеш-кода объекта Account
     * @return Хеш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
