package bg.softuni.springdataintro.businessLayer.services;

import bg.softuni.springdataintro.persistenceLayer.entities.User;


public interface UserService {
    void registerUser(User user);
}