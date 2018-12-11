package com.qa.challenge.ravijaganathan.model.service;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import com.qa.challenge.ravijaganathan.model.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAllAccounts(){

        List<Account> returnList = new ArrayList<>();
        accountRepository.findAll().forEach(returnList::add);
        return returnList;
    }

    public Account addAccount(Account account){
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id){
         accountRepository.deleteById(id);
    }


}
