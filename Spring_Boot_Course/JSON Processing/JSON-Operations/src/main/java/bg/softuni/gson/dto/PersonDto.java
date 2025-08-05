package bg.softuni.gson.dto;

import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.List;

public class PersonDto {
    @Expose
    private  String firstName;
    @Expose
    private String lastName;
    private int age;
    private boolean isMarried;
    @Expose
    private Date birthDate;
    @Expose
    private AddressDto address;
    @Expose
    private List<String> hobbies;

    public PersonDto(String firstName,String lastName,  int age, boolean isMarried, Date birthDate, AddressDto address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
        this.birthDate = birthDate;
        this.address = address;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isMarried=" + isMarried +
                ", birthDate=" + birthDate +
                ", address=" + address +
                ", hobbies=" + hobbies +
                '}';
    }
}
