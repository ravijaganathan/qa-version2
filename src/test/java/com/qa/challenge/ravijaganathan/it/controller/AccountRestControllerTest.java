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
        Account firstAccount = new Account();
        firstAccount.setFirstName("John");
        firstAccount.setLastName("Doe");
        firstAccount.setAccountNumber("1234");


        assertThat(accountService.addAccount(firstAccount)).isEqualTo(firstAccount);

        Account secondAccount = new Account();
        secondAccount.setFirstName("Jane");
        secondAccount.setLastName("Doe");
        secondAccount.setAccountNumber("1235");
        accountService.addAccount(secondAccount);
        assertThat(accountService.addAccount(secondAccount)).isEqualTo(secondAccount);

        Account thirdAccount = new Account();
        thirdAccount.setFirstName("Jim");
        thirdAccount.setLastName("Tailor");
        thirdAccount.setAccountNumber("1236");
        accountService.addAccount(thirdAccount);


        assertThat(accountService.addAccount(thirdAccount)).isEqualTo(thirdAccount);

    }





}