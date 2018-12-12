package com.qa.challenge.ravijaganathan.it.controller;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import com.qa.challenge.ravijaganathan.model.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Int_AccountRestControllerTest {
    @Autowired
    AccountService accountService;


    @Before
    public void setup(){
        accountService.deleteAll();
    }

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


    @Test
    public void findAllAccounts_Test() throws NoSuchMethodException {
        createAccount_test();
        assertThat(accountService.getAllAccounts()).hasSize(3);
    }


    @Test
    public void addAdditional() throws NoSuchMethodException {
        createAccount_test();
        Account fourthAccount = new Account();
        fourthAccount.setFirstName("Steven");
        fourthAccount.setLastName("Doe");
        fourthAccount.setAccountNumber("1238");
        accountService.addAccount(fourthAccount);
        assertThat(accountService.getAllAccounts()).hasSize(4);
    }







}