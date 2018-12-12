package com.qa.challenge.ravijaganathan.model.entitiy;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;

    @Column(name = "FIRSTNAME")
    public String firstName;

    @Column(name = "LASTNAME")
    public String lastName;

    @Column(name = "ACCOUNTNUMBER",unique = false)
    public String AccountNumber;

}
