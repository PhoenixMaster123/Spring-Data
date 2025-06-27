package lab.Relations.models;

import jakarta.persistence.*;
import lab.Relations.BaseEntity;

@Entity
@Table(name = "labels")
public class Label extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "label", fetch = FetchType.LAZY) // mappedBy indicates that this is the inverse side of the relationship | it refers to the field in the Shampoo class that owns the relationship
    private Shampoo shampoo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
