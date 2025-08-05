package bg.softuni.services;

import bg.softuni.data.entities.User;

import java.io.IOException;

public interface UserService {
    public void importData() throws IOException;

    User getRandomUser();
}
