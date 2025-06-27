package lab.TablePerClassStrategy.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("b")
//@Table(name = "bikes")
public class Bike extends Vehicle {
}
