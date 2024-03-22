package com.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // to automatically generate constructors and getter setter methods
@AllArgsConstructor
public class AccountDto {

    private int id;
    private String accountHolderName;
    private double balance;


}
