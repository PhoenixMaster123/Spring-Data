package lab.Relations.models;

import jakarta.persistence.*;
import lab.Relations.BaseEntity;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "batches")
public class ProductionBatch extends BaseEntity {
    
    @Column(name = "date")
    private LocalDate date;

    @OneToMany(mappedBy = "batch")
    private Set<Shampoo> shampoo; // Fetch by default is LAZY, meaning that the shampoos will not be loaded until explicitly accessed.
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
