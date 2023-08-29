package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс, представляющий банковский сервис для управления пользователями и их счетами
 * @author DMITRY ARININ
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавления нового пользователя в коллекцию
     * Если такой пользователь уже есть в коллекции - добавление не происходит
     * Если такой пользователь в коллекции новый - он добавляется
     * @param user который добавляется в коллекцию
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя из коллекции на основе его паспортных данных
     * @param passport Паспортные данные пользователя
     * @return {@code true} если пользователь был успешно удален, {@code false} если пользователь не найден
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Добавляет банковский счет к пользователю по его паспортным данным
     * @param passport Паспортные данные пользователя
     * @param account  Добавляемый банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !getAccounts(user).contains(account)) {
            getAccounts(user).add(account);
        }
    }

    /**
     * Поиск пользователя по его паспортным данным
     * @param passport Паспортные данные пользователя
     * @return Объект пользователя или {@code null}, если пользователь не найден
     */
    public User findByPassport(String passport) {
        User findUser = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                findUser = user;
                break;
            }
        }
        return findUser;
    }

    /**
     * Поиск банковского счета пользователя по реквизитам
     * @param passport  Паспортные данные пользователя
     * @param requisite Реквизиты банковского счета
     * @return Банковский счет или {@code null}, если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account acc : getAccounts(user)) {
                if (requisite.equals(acc.getRequisite())) {
                    account = acc;
                    break;
                }
            }
        }
        return account;
    }

    /**
     * Переводит указанную сумму денег между банковскими счетами
     * @param srcPassport   Паспортные данные отправителя
     * @param srcRequisite  Реквизиты банковского счета отправителя
     * @param destPassport  Паспортные данные получателя
     * @param destRequisite Реквизиты банковского счета получателя
     * @param amount        Сумма перевода
     * @return {@code true}, если перевод выполнен успешно, {@code false} в случае ошибки
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null & srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Получает список банковских счетов, принадлежащих указанному пользователю
     * @param user Пользователь, для которого нужно получить список счетов
     * @return Список банковских счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
