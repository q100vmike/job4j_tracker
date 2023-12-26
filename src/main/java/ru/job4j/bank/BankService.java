package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
                users.remove(new User(passport, ""));
    }

    public void addAccount(String passport, Account account) {
        List user = users.get(findByPassport(passport));

        if (Objects.nonNull(user) && !user.contains(account)) {
            user.add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (Objects.nonNull(user)) {
            for (Account acc : this.getAccounts(user)) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}