package com.qa.challenge.ravijaganathan.controller;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import com.qa.challenge.ravijaganathan.model.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AccountRestController {

    @Autowired
    AccountService accountService;


    @PostMapping("/account-project/rest/account/json")
    ResponseMessage newEmployee(@RequestBody Account account) {
        Account createdAccount = accountService.addAccount(account);
        ResponseMessage responseMessage = new ResponseMessage();
        if(Optional.ofNullable(createdAccount).isPresent()) {
            responseMessage.setMessage("Successfully Added");
        }

        return responseMessage;
    }



    class ResponseMessage{
        String message;

        public String getMessage() {
            return message;
        }

        public ResponseMessage() {}
        public ResponseMessage(String message) {
            this.message = message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}


