package softuni.exam.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sellers")
public class Seller extends BaseEntity{
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name= "last_name", nullable = false, unique = true)
    private String lastName;

    @Column(name = "personal_number", nullable = false, unique = true)
    private String personalNumber;

    public Seller() {}
}
