package com.qa.challenge.ravijaganathan.ut.model.repository;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import com.qa.challenge.ravijaganathan.model.repository.AccountRepository;
import com.qa.challenge.ravijaganathan.utils.ChallengeTestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

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
        accountRepository.deleteAll();
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
        assertThat(accountList.get(0).getFirstName()).isEqualTo("John");
        assertThat(accountList.get(0).getLastName()).isEqualTo("Doe");
        assertThat(accountList.get(0).getAccountNumber()).isEqualTo("1234");

    }

    @Test
    public void DeleteAccount_Test() throws NoSuchMethodException {

        AddAccount_Test();
        accountList = (List<Account>) accountRepository.findAll();
        Optional<Account> deleteAccount = accountList.stream().findFirst();

        assertThat(accountList).hasSize(1);
        accountRepository.deleteById(deleteAccount.get().getId());
        accountList = (List<Account>) accountRepository.findAll();
        assertThat(accountList).hasSize(0);


    }


}