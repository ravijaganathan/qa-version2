package com.qa.challenge.ravijaganathan.controller;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import com.qa.challenge.ravijaganathan.model.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountRestController {

    @Autowired
    AccountService accountService;


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



    class ResponseMessage{
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


