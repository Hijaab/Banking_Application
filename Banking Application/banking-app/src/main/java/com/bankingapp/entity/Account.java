package com.bankingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //automatically creates getter setter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "accounts")
@Entity //to make the class as jpa entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "account_holder_name")
    private String accountHolderName;
    private double balance;



}
