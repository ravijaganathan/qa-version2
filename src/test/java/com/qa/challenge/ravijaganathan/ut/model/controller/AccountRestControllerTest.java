package com.qa.challenge.ravijaganathan.ut.model.controller;

import com.google.gson.Gson;
import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import com.qa.challenge.ravijaganathan.model.service.AccountService;
import com.qa.challenge.ravijaganathan.utils.MockedTestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AccountRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountService accountService;

    @Captor
    ArgumentCaptor<Account> accountArgumentCaptor;


    MockedTestData mockedTestData = new MockedTestData() ;

    @Test
    public void createAccount_controller_test() throws NoSuchMethodException,Exception {
        when(accountService.addAccount(mockedTestData.getDummyAccount())).thenReturn(mockedTestData.getDummyAccount());


        Gson gson = new Gson();
        String json = gson.toJson(mockedTestData.getDummyAccount());
        Account intestAccount = gson.fromJson(json,Account.class);
        String inputJson = gson.toJson(intestAccount);

        MvcResult mvcResult = mockMvc.perform(
                                        MockMvcRequestBuilders.post("/account-project/rest/account/json")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(inputJson))
                                        .andReturn();

        verify(accountService).addAccount(accountArgumentCaptor.capture());
    }



    @Test
    public void deleteAccount_controller_test() throws NoSuchMethodException,Exception {
        throw new NoSuchMethodException();
    }

}