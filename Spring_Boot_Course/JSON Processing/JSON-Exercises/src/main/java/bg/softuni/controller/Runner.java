package bg.softuni.controller;

import bg.softuni.services.CategoryService;
import bg.softuni.services.ProductService;
import bg.softuni.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final UserService userService;
    private final CategoryService categoryService;

    private final ProductService productService;

    @Autowired
    public Runner(UserService userService, CategoryService categoryService, ProductService productService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {

        //userService.importData();
        //categoryService.importData();
        //productService.importData();

        productService.getUnsoldProductsInRange(500, 1000);
    }
}
