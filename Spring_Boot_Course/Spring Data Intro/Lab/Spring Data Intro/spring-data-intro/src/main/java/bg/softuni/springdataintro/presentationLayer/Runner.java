package bg.softuni.springdataintro.presentationLayer;

import bg.softuni.springdataintro.businessLayer.services.AccountServiceImpl;
import bg.softuni.springdataintro.businessLayer.services.UserService;
import bg.softuni.springdataintro.persistenceLayer.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Note: This is only examples, not everything is with the right implementation or with the best practices.

@Component
public class Runner implements CommandLineRunner {

    private final UserService userService;
    private final AccountServiceImpl accountService;

    public Runner(UserService userService, AccountServiceImpl accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started running the application...");

       // accountService.withdrawMoney(BigDecimal.valueOf(100), 123L);

        User user = new User("JaneDoe", 30);

        userService.registerUser(user);
    }
}
