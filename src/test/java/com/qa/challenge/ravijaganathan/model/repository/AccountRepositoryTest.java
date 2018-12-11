package com.qa.challenge.ravijaganathan.model.repository;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import com.qa.challenge.ravijaganathan.utils.ChallengeTestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    ChallengeTestUtils challengeTestUtils;
    List<Account> accountList;

    @Before
    public void setup(){
        challengeTestUtils = new ChallengeTestUtils();
//        accountList.removeAll(accountList);
    }

    @Test
    public void empty_findAllAccount_Test() throws NoSuchMethodException {
        accountList = (List<Account>) accountRepository.findAll();
        assertThat(accountList).hasSize(0);
    }

    @Test
    public void empty_AddAccount_Test() throws NoSuchMethodException {
        accountList = (List<Account>) accountRepository.findAll();
        assertThat(accountList).hasSize(0);
        accountRepository.save(new Account());
        List<Account> newAccountList = (List<Account>) accountRepository.findAll();
        assertThat(newAccountList).hasSize(1);
    }

    @Test
    public void AddAccount_Test(){
        accountList = (List<Account>) accountRepository.findAll();
        assertThat(accountList).hasSize(0);

        accountRepository.save(challengeTestUtils.getFirst_TestAccount());
        accountList = (List<Account>) accountRepository.findAll();

        assertThat(accountList).hasSize(1);
    }


    @Test
    public void duplicate_AddAccount_Test(){
        AddAccount_Test();
        accountRepository.save(challengeTestUtils.getFirst_TestAccount());
        accountList = (List<Account>) accountRepository.findAll();

        assertThat(accountList).hasSize(2);

    }



}