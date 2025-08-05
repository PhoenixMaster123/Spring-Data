package bg.softuni.services.dtos;

import bg.softuni.data.entities.Product;

import java.math.BigDecimal;

public class UnsolvedProductInfoDto {

    private String name;

    private BigDecimal price;

    private String seller;


    public UnsolvedProductInfoDto(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.seller = product.getSeller().getFirstName() + " " + product.getSeller().getLastName();
    }

    public UnsolvedProductInfoDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
