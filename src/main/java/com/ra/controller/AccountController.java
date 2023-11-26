package com.ra.controller;

import com.ra.model.Account;
import com.ra.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/accountsController")
public class AccountController {
    @Autowired
    AccountService accountService;
    private static final int SIZE = 3;
    private static int pageDefault = 1;
    private static String directionDefault = "ASC";
    private static String sortByDefault = "email";
    private static String emailDefault = "";

    @GetMapping(value = "/getAll")
    public ModelAndView displayAccount(Optional<String> email, Optional<Integer> page,
                                       Optional<String> direction, Optional<String> sortBy) {
        ModelAndView modelAndView = new ModelAndView("accounts");
        pageDefault = page.orElse(pageDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        emailDefault = email.orElse(emailDefault);
        List<Account> accountList = accountService.displayAccounts(emailDefault, pageDefault - 1, SIZE,
                directionDefault, sortByDefault);
        List<Integer> listPage = accountService.getListPage(emailDefault, SIZE);
        modelAndView.addObject("listPage", listPage);
        modelAndView.addObject("direction", directionDefault);
        modelAndView.addObject("sortBy", sortByDefault);
        modelAndView.addObject("email", emailDefault);
        modelAndView.addObject("accountsList", accountList);
        return modelAndView;
    }

    @GetMapping(value = "/searchAccount")
    public String searchAccount(@RequestParam(name = "accountSearch") String email) {
        emailDefault = email;
        return "redirect:getAll";
    }

    @GetMapping(value = "/initAddAccount")
    public String initAddAccount(ModelMap modelMap) {
        Account newAccount = new Account();
        modelMap.addAttribute("newAccount", newAccount);
        return "accountInit";
    }

    @PostMapping(value = "/addNewAccount")
    public String addNewAccount(Account account) {
        boolean addResult = accountService.save(account);
        if (addResult) {
            return "redirect:getAll";
        } else {
            return "redirect:error";
        }
    }

    @GetMapping(value = "/initUpdateAccount")
    public String initUpdateAccount(@RequestParam int accId, ModelMap modelMap) {
        Account updateAccount = accountService.getAccountById(accId);
        modelMap.addAttribute("updateAccount", updateAccount);
        return "accountUpdate";
    }

    @PostMapping(value = "/updateAccount")
    public String updateAccount(Account account) {
        boolean updateResult = accountService.save(account);
        if (updateResult) {
            return "redirect:getAll";
        } else {
            return "redirect:error";
        }
    }

    @GetMapping(value = "/blockOrActivateAccount")
    public String blockOrActivateAccount(@RequestParam int accId, @RequestParam boolean accStatus) {
        Account account = accountService.getAccountById(accId);
        account.setAccStatus(!accStatus);
        boolean saveResult = accountService.save(account);
        if (saveResult) {
            return "redirect:getAll";
        } else {
            return "error";
        }

    }
}
