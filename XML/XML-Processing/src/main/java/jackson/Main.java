package jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jackson.dtos.Order;
import jackson.dtos.Product;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); // Enable pretty printing

        Product product = new Product("Laptop", "Dell");
        Order order = new Order(product,10, BigDecimal.TEN);

        xmlMapper.writeValue(System.out, order);
    }
}
