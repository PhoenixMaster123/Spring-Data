package bg.softuni.springdataintro.businessLayer.services;

import bg.softuni.springdataintro.persistenceLayer.entities.Account;
import bg.softuni.springdataintro.persistenceLayer.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void withdrawMoney(BigDecimal amount, Long accountId) {
        // Check if the account exists (Variant 1)
        Account account = accountRepository.findById(accountId).orElseThrow(()->new RuntimeException("Missing account with id: " + accountId));

        // Check if the account exists (Variant 2)
        // Optional<Account> accountOptional = repository.findById(accountId);
        // if (accountOptional.isEmpty()) {
        //     throw new RuntimeException("Missing account with id: " + accountId);
        // }

        // account.setBalance(account.getBalance().subtract(amount));
       if(account.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Insufficient funds in account with id: " + accountId);
        }
       BigDecimal newBalance = account.getBalance().subtract(amount);
       account.setBalance(newBalance);

       accountRepository.save(account);
    }
}
