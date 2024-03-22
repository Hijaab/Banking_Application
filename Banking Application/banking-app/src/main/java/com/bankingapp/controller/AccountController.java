package com.bankingapp.controller;

import com.bankingapp.dto.AccountDto;
import com.bankingapp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
//controller layer is dependent on service layer
// here creating rest api it will internally call this method createAccount
@RestController // creates this class as spring mvc rest controller class
@RequestMapping("/api/accounts") // base url for all the rest api which is going to define within this AccountController class
public class AccountController {

    // injecting the dependency
    // defining the field
    private AccountService accountService;

    // we need not add @Controller because this class has only one constructor so spring will automatically inject the dependency
    // constructor base dependency injection to inject this AccontService dependency
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // add account REST API
    // how to do that: first create a method and we will make tha method as rest api using spring annotation
    // this method defines how to handle http post request so we use @PostMapping
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){ // @RequestBody will now map to this java object AccountDto, @RequestBody is of json it will automatically convert into java object
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // get account REST API
    // it returns the account object and returns the ok method which returns internally the http status
    // @Get Mapping maps the in coming http get request to this particular method
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable int id){ // @PathVariable identifies the path {/id} for this method
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    // deposit REST API
    @PutMapping("/{id}/deposit") // to map incoming http put request to this method
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String, Double> request){ // Map<String, double> key as String while type as double, amount in request body so we use Map
        // @RequestBody map the request json body into this map java object
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount); // amount obtained from the request object, passing key as an amount
        return ResponseEntity.ok(accountDto);
    }

    // withdraw REST API
    @PutMapping("/{id}/withdraw") // to map incoming http put request to this method
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request){ // Map<String, double> key as String while type as double, amount in request body so we use Map ,
        double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    // get all accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccount(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // delete account REST API
    @DeleteMapping("/{id}") // incoming http delete request to this method
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted successfully!");
    }

}
