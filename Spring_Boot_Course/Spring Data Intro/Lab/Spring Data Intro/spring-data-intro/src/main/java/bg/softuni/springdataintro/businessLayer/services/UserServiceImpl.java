package bg.softuni.springdataintro.businessLayer.services;

import bg.softuni.springdataintro.persistenceLayer.entities.Account;
import bg.softuni.springdataintro.persistenceLayer.entities.User;
import bg.softuni.springdataintro.persistenceLayer.repositories.AccountRepository;
import bg.softuni.springdataintro.persistenceLayer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void registerUser(User user) {
        // Convert data to User entity if necessary
        // Perform Validation or business logic here if needed
        // Save the user to the database

        Account account = new Account();
        user.addAccount(account);
        userRepository.save(user);
    }
}
// @Autowired
// The @Autowired annotation is a Spring Framework annotation that allows for automatic dependency injection.
// It is used to automatically wire beans in Spring applications, meaning that Spring will automatically resolve and inject the required dependencies into the annotated field, constructor, or method.
// In this case, the @Autowired annotation is applied to the userRepository field in the UserServiceImpl class.
// This means that Spring will automatically inject an instance of UserRepository into this field when it creates an instance of UserServiceImpl.

// @Bean
// The @Bean annotation is used in Spring to indicate that a method produces a bean that should be managed by the Spring container.
// It is typically used in configuration classes to define beans that can be injected into other components.

// @Component
// The @Component annotation is a Spring Framework annotation that indicates that a class is a Spring component.
// It is used to mark a class as a Spring-managed component, which means that Spring will automatically detect and register it as a bean in the application context during component scanning.
// In this case, the @Service annotation is a specialization of the @Component annotation, indicating that this class is a service layer component.
// The @Service annotation is used to indicate that a class is a service component in the business layer of the application.

// @Service
// The @Service annotation is a specialization of the @Component annotation in Spring.
// It is used to indicate that a class is a service component in the business layer of the application.
// The @Service annotation is typically used to annotate classes that contain business logic or service methods.
// It is a way to indicate that the class is a service and should be treated as such by the Spring container.
// In this case, the UserServiceImpl class is annotated with @Service, indicating that it is a service component responsible for user-related operations.