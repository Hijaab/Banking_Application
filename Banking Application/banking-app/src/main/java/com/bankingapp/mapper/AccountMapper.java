package com.bankingapp.mapper;

import com.bankingapp.dto.AccountDto;
import com.bankingapp.entity.Account;

public class AccountMapper {

    // creating a static method
    //converting this AccountDto into Account jpa entity
    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }

    // creating a static method
    //converting this Account into AccountDto jpa entity
    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto =new AccountDto(
                (short) account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
