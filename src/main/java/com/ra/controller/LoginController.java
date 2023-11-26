package com.ra.controller;

import com.ra.model.Account;
import com.ra.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/loginController")
public class LoginController {
    @Autowired
    AccountService accountService;

    @GetMapping(value = "/loginInterface")
    public String loginInterface() {
        return "login";
    }

    @GetMapping(value = "/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @PostMapping(value = "/checkPermission")
    public String checkPermission(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        List<Account> accountList = accountService.getAllAccount();
        for (Account account : accountList) {
            if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
                return "dashboard";
            }
        }
        return "error";
    }
}
