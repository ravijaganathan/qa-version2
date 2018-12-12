package com.qa.challenge.ravijaganathan.controller;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import com.qa.challenge.ravijaganathan.model.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountRestController {

    @Autowired
    AccountService accountService;

    @PostConstruct
    public void init() {
        Account firstAccount = new Account();
        firstAccount.setFirstName("John");
        firstAccount.setLastName("Doe");
        firstAccount.setAccountNumber("1234");

        accountService.addAccount(firstAccount);


        Account secondAccount = new Account();
        secondAccount.setFirstName("Jane");
        secondAccount.setLastName("Doe");
        secondAccount.setAccountNumber("1235");
        accountService.addAccount(secondAccount);


        Account thirdAccount = new Account();
        thirdAccount.setFirstName("Jim");
        thirdAccount.setLastName("Tailor");
        thirdAccount.setAccountNumber("1236");
        accountService.addAccount(thirdAccount);
    }

    @GetMapping("/account-project/rest/account/json")
    List<Account> findAllAccount() {
        return accountService.getAllAccounts();
    }


    @PostMapping("/account-project/rest/account/json")
    ResponseMessage newEmployee(@RequestBody Account account) {
        Account createdAccount = accountService.addAccount(account);
        ResponseMessage responseMessage = new ResponseMessage();
        if(Optional.ofNullable(createdAccount).isPresent()) {
            responseMessage.setMessage("account has been successfully added");
        }

        return responseMessage;
    }


    @RequestMapping(method= RequestMethod.DELETE,value="/account-project/rest/account/json/{id}")
    public void deleteSecurity(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }



    public class ResponseMessage{
        String message;

        public String getMessage() {
            return message;
        }

        public ResponseMessage() {}

        public void setMessage(String message) {
            this.message = message;
        }
    }
}


