package com.bankingapp.service.implementation;

import com.bankingapp.dto.AccountDto;
import com.bankingapp.entity.Account;
import com.bankingapp.mapper.AccountMapper;
import com.bankingapp.repository.AccountRepository;
import com.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // automatically ceate a spring bean for this class
public class AccountServiceImplementation implements AccountService {


    // injecting the dependency
    private AccountRepository accountRepository;

    // @Autowired = to automatically inject the dependency
    public AccountServiceImplementation(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override // we hve created saved account now it will call accountRepository to save the account in to the database
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(int id) {

        // if account is not find in repository an exception will be thrown that ccunt doesnot found
        Account account  = accountRepository
                .findById((long) id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        // check whether the given id is present in the database or not, if not exist then runtime exception will be thrown
        Account account  = accountRepository
                .findById((long) id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
        double total = account.getBalance() + amount; // addition of balance and deposited money
        account.setBalance(total); // set the total as balance
        Account savedAccount = accountRepository.save(account);   // to save the total balance account it in database, return the save account object
        return AccountMapper.mapToAccountDto(savedAccount); // converting this account gpo entity into account dto
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        // if account is not find in repository an exception will be thrown that account does not found
        Account account  = accountRepository
                .findById((long) id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));

        // if the withdrawn amount is greater than the balance, then we will throw an exception for insufficient amount
        if (account.getBalance() < amount){
            throw new RuntimeException("Insufficient Amount");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) ->  AccountMapper.mapToAccountDto(account)) // stream has map method
                .collect((Collectors.toList())); // returning the list from the stream, list contains list of account dto

    }

    @Override
    public void deleteAccount(Long id) {
        Account account  = accountRepository
                .findById((long) id)
                .orElseThrow(() -> new RuntimeException("Account does not exits"));

        accountRepository.deleteById(id);
    }


}
