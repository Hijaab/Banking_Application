package com.bankingapp.repository;

import com.bankingapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> { // JPA entity name and type if the primary key

}
