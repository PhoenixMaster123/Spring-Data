package softuni.exam.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
public class Country extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "capital")
    private String capital;

    @Override
    public String toString() {
        return name;
    }
}
