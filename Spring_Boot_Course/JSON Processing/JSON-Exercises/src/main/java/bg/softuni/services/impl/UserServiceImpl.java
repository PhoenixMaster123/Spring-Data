package bg.softuni.services.impl;

import bg.softuni.data.entities.User;
import bg.softuni.data.repositories.UserRepository;
import bg.softuni.services.UserService;
import bg.softuni.services.dtos.ImportUserDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.gson = new GsonBuilder().create();
        this.modelMapper = new ModelMapper();
    }
    @Override
    public void importData() throws IOException {
        // Read JSON file → DTO objects
        // Validate DTO objects (Manuell or in the DTO class)
        // Convert DTO objects to Entity objects
        // Save Entity objects to the database

        Path jsonFilePath = Path.of("src/main/resources/json_data/users.json");

        List<String> lines = Files.readAllLines(jsonFilePath);

        ImportUserDto[] fromJson = this.gson.fromJson(String.join("", lines), ImportUserDto[].class);
        for (ImportUserDto importUserDto : fromJson) {
            if (importUserDto.getLastName() == null || importUserDto.getLastName().length() < 3) {
                System.out.println("Invalid user: " + importUserDto.getLastName());
                continue;
            }
            // Convert DTO to Entity
            User user = this.modelMapper.map(importUserDto, User.class);

            // Save to the database
            this.userRepository.save(user);
        }
    }

    @Override
    public User getRandomUser() {
        Random random = new Random();

        long totalUsers = this.userRepository.count();

        if (totalUsers == 0) {
            return null; // No users in the database
        }

        while (true) {

            long id = random.nextLong(totalUsers + 1);

             Optional<User> user = this.userRepository.findById(id);

            if (user.isPresent()) {
                return user.get();
            }
        }
    }
}
