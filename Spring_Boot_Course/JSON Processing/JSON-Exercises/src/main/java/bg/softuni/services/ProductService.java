package bg.softuni.services;

import java.io.IOException;
import java.math.BigDecimal;

public interface ProductService {

    void importData() throws IOException;

    void getUnsoldProductsInRange(double lowerBound, double upperBound);
}
