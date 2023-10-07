package model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account acc) throws Exception {
        if (!isValidUsername(acc.getUsername())) {
            throw new Exception("Username must be at least 5 characters and have no spaces.");
        }

        if (!isValidPassword(acc.getPassword())) {
            throw new Exception("Password must be at least 6 characters and have no spaces.");
        }

        if (isUsernameTaken(acc.getUsername())) {
            throw new Exception("Username already exists in the database.");
        }

        accounts.add(acc);
    }

    public Account find(Account acc) {
        for (Account account : accounts) {
            if (account.getUsername().equals(acc.getUsername()) && account.getPassword().equals(acc.getPassword())) {
                return account;
            }
        }
        return null;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    private boolean isValidUsername(String username) {
        return username.length() >= 5 && !username.contains(" ");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 6 && !password.contains(" ");
    }

    private boolean isUsernameTaken(String username) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
