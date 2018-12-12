package com.qa.challenge.ravijaganathan.it.controller;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import com.qa.challenge.ravijaganathan.model.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRestControllerTest {
    @Autowired
    AccountService accountService;

    @Test
    public void createAccount_test(){
        Account account = new Account();
        account.setFirstName("John");
        account.setLastName("Doe");
        account.setAccountNumber("1234");
        assertThat(accountService.addAccount(account)).isEqualTo(account);
    }


}