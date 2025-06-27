package lab.TablePerClassStrategy.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("t")
//@Table(name = "trucks")
public class Truck extends Vehicle {
    @Column(name = "load_capacity")
    private Double getLoadCapacity;

    public Double getLoadCapacity() {
        return getLoadCapacity;
    }

    public void setLoadCapacity(Double loadCapacity) {
        this.getLoadCapacity = loadCapacity;
    }
}
