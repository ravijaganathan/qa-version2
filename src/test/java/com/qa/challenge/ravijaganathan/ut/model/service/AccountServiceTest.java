package com.qa.challenge.ravijaganathan.ut.model.service;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import com.qa.challenge.ravijaganathan.model.repository.AccountRepository;
import com.qa.challenge.ravijaganathan.model.service.AccountService;
import com.qa.challenge.ravijaganathan.utils.MockedTestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @MockBean
    AccountRepository accountRepository;

    MockedTestData mockedTestData = new MockedTestData();

    @Test
    public void service_getAllAccounts_Test() throws NoSuchMethodException {
        when(accountRepository.findAll()).thenReturn(mockedTestData.getAccountList());
        assertThat(accountService.getAllAccounts()).hasSize(4);
    }

    @Test
    public void createAccount_Test() throws NoSuchMethodException {
        Account account = new Account();

        account.setFirstName("Ravi");
        account.setLastName("Jaganathan");
        account.setAccountNumber("1111");
        when(accountRepository.save(account)).thenReturn(account);

        assertThat(accountService.addAccount(account)).isEqualTo(account);
    }

    @Test
    public void deleteAccount() throws NoSuchMethodException {
        accountService.deleteAccount((long) 1);
        verify(accountRepository,times(1)).deleteById((long)1);
    }
}