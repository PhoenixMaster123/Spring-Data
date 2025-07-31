package bg.softuni.gson.dto;

import com.google.gson.annotations.Expose;

public class AddressDto {
    @Expose
    private String country;
    @Expose
    private String city;
    @Expose
    private String street;

    public AddressDto(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }
}
