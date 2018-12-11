package com.qa.challenge.ravijaganathan.model.entitiy;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;

    @Column(name = "FIRST_NAME")
    public String firstName;

    @Column(name = "LAST_NAME")
    public String lastName;

    @Column(name = "ACCOUNT_NUMBER",unique = true)
    public String AccountNumber;

}
