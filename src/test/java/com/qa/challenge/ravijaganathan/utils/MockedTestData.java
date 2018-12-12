package com.qa.challenge.ravijaganathan.utils;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockedTestData {
    List<Account> accountList = new ArrayList<>();
    Account account = new Account();
    public MockedTestData(){
        add2AccountList((long) 1,"First","TestUser","1234");
        add2AccountList((long)2,"Second","UserTest","1423");
        add2AccountList((long)3,"Third","TestUser","1324");
        add2AccountList((long)4,"Fourth","UserTest","2134");
    }

    public void add2AccountList(Long id,String firstName,String lastName,String accountNumber){
        account.setId(id);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setAccountNumber(accountNumber);

        this.accountList.add(account);
    }



    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Account getDummyAccount() {
        Account dummyAccount = new Account();
        dummyAccount.setId((long)5);
        dummyAccount.setFirstName("Ravi");
        dummyAccount.setLastName("Jaganathan");
        dummyAccount.setAccountNumber("5896");
        return dummyAccount;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
