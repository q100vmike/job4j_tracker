package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * Класс описывает работу банковского сервиса - работу с пользователями и их счетами.
 * Перевод средств между счетами
 * @author KUSTOV MIKHAIL
 * @version 1.0
 */
public class BankService {
    /**
     * Map хранит пользователя и его счета
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавления нового пользователя
     * @param user - пользователь (пасспорт и имя)
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаления пользователя
     * @param passport - номер паспорта строкой
     */
    public void deleteUser(String passport) {
                users.remove(new User(passport, ""));
    }

    /**
     * Метод добавления нового счета для пользователя
     * @param passport - определяет пользователя которому добавляем счет
     * @param account - счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (Objects.nonNull(user)) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод поиска пользователя по номеру паспорта
     * @param passport - номер паспорта
     * @return возвращает key если пользователь найден и null если нет
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Метод поиска счета пользователя
     * @param passport паспорт
     * @param requisite счет
     * @return возвращает Account пользователя если найден и null если не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (Objects.nonNull(user)) {
            for (Account acc : users.get(user)) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    /**
     * Метод перевода средств между пользователями
     * @param sourcePassport паспорт пользователя от которого переводим средства
     * @param sourceRequisite номер счета с которого переводим средства
     * @param destinationPassport паспорт пользователя которому переводим средства
     * @param destinationRequisite номер счета на который переводим средства
     * @param amount сумма перевода
     * @return true если перевод произошел и false если нет
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account accSource = this.findByRequisite(sourcePassport, sourceRequisite);
        Account accDest = this.findByRequisite(destinationPassport, destinationRequisite);

        if (Objects.nonNull(accSource) && Objects.nonNull(accDest)) {
            if (accSource.getBalance() >= amount) {
                accSource.setBalance(accSource.getBalance() - amount);
                accDest.setBalance(accDest.getBalance() + amount);
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод возвращает все счета пользователя
     * @param user пользователь по которому запрашиваем счета
     * @return Account все счета пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}