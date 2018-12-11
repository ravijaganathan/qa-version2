package com.qa.challenge.ravijaganathan.ut.model.service;

import com.qa.challenge.ravijaganathan.model.repository.AccountRepository;
import com.qa.challenge.ravijaganathan.model.service.AccountService;
import com.qa.challenge.ravijaganathan.utils.MockedTestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @MockBean
    AccountRepository accountRepository;

    @Test
    public void service_getAllAccounts_Test() throws NoSuchMethodException {
        MockedTestData mockedTestData = new MockedTestData();
        Mockito.when(accountRepository.findAll()).thenReturn(mockedTestData.getAccountList());
        assertThat(accountService.getAllAccounts()).hasSize(4);
    }
}