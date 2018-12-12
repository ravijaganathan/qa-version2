package com.qa.challenge.ravijaganathan.model.repository;

import com.qa.challenge.ravijaganathan.model.entitiy.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {

}
