package com.qa.challenge.ravijaganathan.model.repository;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void empty_findAllAccount_Test() throws NoSuchMethodException {
        List<Account> accountList = (List<Account>) accountRepository.findAll();
        assertThat(accountList).hasSize(0);
    }

    @Test
    public void empty_AddAccount_Test() throws NoSuchMethodException {
        List<Account> accountList = (List<Account>) accountRepository.findAll();
        assertThat(accountList).hasSize(0);

        accountRepository.save(new Account());
        List<Account> newAccountList = (List<Account>) accountRepository.findAll();
        assertThat(newAccountList).hasSize(1);
    }
}