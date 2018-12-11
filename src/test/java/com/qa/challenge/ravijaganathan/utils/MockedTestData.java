package com.qa.challenge.ravijaganathan.utils;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;

import java.util.ArrayList;
import java.util.List;

public class MockedTestData {
    List<Account> accountList = new ArrayList<>();
    Account account = new Account();
    public MockedTestData(){
        account.setFirstName("Ravi");
        account.setLastName("Jaganathan");
        account.setAccountNumber("1234");
        accountList.add(account);
        account.setFirstName("Suresh");
        account.setLastName("Jaganathan");
        account.setAccountNumber("4321");
        accountList.add(account);
        account.setFirstName("Santander");
        account.setLastName("Spain");
        account.setAccountNumber("1589");
        accountList.add(account);


    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
