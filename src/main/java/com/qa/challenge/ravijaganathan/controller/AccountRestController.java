package com.qa.challenge.ravijaganathan.controller;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import com.qa.challenge.ravijaganathan.model.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {

    @Autowired
    AccountService accountService;


    @RequestMapping(method= RequestMethod.POST,value="/account-project/rest/account/json")
    public void addSecurity(@RequestBody Account account) {
        accountService.addAccount(account);
    }




}

class ResponseMessage{
    String message;

    public ResponseMessage(String message) {
        this.message = message;
    }
}

