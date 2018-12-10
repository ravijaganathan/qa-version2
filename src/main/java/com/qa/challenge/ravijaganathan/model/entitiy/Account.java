package com.qa.challenge.ravijaganathan.model.entitiy;

import org.hibernate.annotations.Generated;

import javax.persistence.*;


@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "FIRST_NAME")
    String firstName;

    @Column(name = "LAST_NAME")
    String lastName;

    @Column(name = "ACCOUNT_NUMBER")
    String AccountNumber;
}
