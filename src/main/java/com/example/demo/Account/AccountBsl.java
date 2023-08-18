package com.example.demo.Account;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountBsl {
    private ArrayList<Account> accounts = new ArrayList<Account>();

    public AccountBsl() {
    }

    public AccountBsl(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public Account getAccount(String username, String password) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    // CREATE an Account
    public void createNewAccount(int id, String username, String password) {
        accounts.add(
                new Account(id, username, password)
        );
    }

    // READ an account
    public Account getAccountById(int id) {
        for (Account account : accounts) {
            if (id == account.getId()) {
                return account;
            }
        }
        return null;
    }

    // DELETE an Account
    public String deleteAccount(int id) {
        for (Account account : accounts) {
            if (id == account.getId()) {
                accounts.remove(account);
                return "Account Deleted";
            }
        }
        // TODO: Shifting ID after Deleting an account

        return "Account not found";
    }

    // CRUD Operations...

    // UPDATE an Account
    public String updateAccount(Account account) {
        for (Account acc : accounts) {
            if (acc.getId() == account.getId()) {
                Account newAcc;
                newAcc = new Account(account.getId(), account.getUsername(), account.getPassword());
                // Update record
                accounts.set(acc.getId() - 1, newAcc);
                return "Account Updated";
            }
        }
        return "Account not found";
    }

    public ArrayList<Account> getAllAccounts() {
        return accounts;
    }

    // SignUp
    public String signUp(Account account) {
        account.setId(accounts.size() + 1);
        Account acc = getAccount(account.getUsername(), account.getPassword());
        if (acc == null) {
            createNewAccount(account.getId(), account.getUsername(), account.getPassword());
            return "Signed Up Successfully";
        } else {
            return "Account Already in use";
        }
    }

    // LogIn
    public String logIn(Account account) {
        Account acc = getAccount(account.getUsername(), account.getPassword());
        if (acc != null) {
            return "Logged In Successfully";
        } else {
            return "Invalid Username or password";
        }
    }

    // CRUD operations
}
