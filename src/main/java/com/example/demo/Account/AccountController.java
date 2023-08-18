package com.example.demo.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "api/v1/Account")
public class AccountController {
    private AccountBsl accountBsl;

    public AccountController() {
    }

    @Autowired
    public AccountController(AccountBsl accountBsl) {
        this.accountBsl = accountBsl;
    }

    @PostMapping(value = "/SignUp")
    public String signUp(@RequestBody Account account) {
        return accountBsl.signUp(account);
    }

    @PostMapping(value = "/LogIn")
    public String logIn(@RequestBody Account account) {
        return accountBsl.logIn(account);
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteAccount(@PathVariable int id) {
        return accountBsl.deleteAccount(id);
    }

    @PostMapping(value = "/update")
    public String updateAccount(@RequestBody Account account) {
        return accountBsl.updateAccount(account);
    }

    @GetMapping(value = "/getAccountById/{id}")
    public Account getAccountById(@PathVariable int id) {
        return accountBsl.getAccountById(id);
    }

    @GetMapping(value = "/getAllAccounts")
    public ArrayList<Account> getAllAccounts() {
        return accountBsl.getAllAccounts();
    }
}
