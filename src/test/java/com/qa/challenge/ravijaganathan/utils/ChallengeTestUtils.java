package com.qa.challenge.ravijaganathan.utils;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import com.qa.challenge.ravijaganathan.model.repository.AccountRepository;

public class ChallengeTestUtils {

    Account account;
    AccountRepository accountRepository;

    public Account getFirst_TestAccount(){

        Account account = new Account();
        account.setId((long)1);
        account.setFirstName("John");
        account.setLastName("Doe");
        account.setAccountNumber("1234");

        return account;
    }

}
