package lab.Relations.models;

import jakarta.persistence.*;
import lab.Relations.BaseEntity;

import java.util.Set;

@Entity
@Table(name = "shampoos")
public class Shampoo extends BaseEntity {
    @Column(name = "brand")
    private String brand;

    // @OneToOne(optional = false) // optional = false means that this relationship is mandatory
    // @JoinColumn(nullable = false) is the equivalent @OneToOne(optional = false)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false) // nullable = false means that this column cannot be null in the database (not optional)
    private Label label;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", nullable = false)
    private ProductionBatch batch;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) // CascadeType.REMOVE means that if a Shampoo is deleted, its associated Ingredients will also be deleted
    @JoinTable(
            name = "shampoos_ingredients",
            joinColumns = @JoinColumn(name = "shampoo_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredients;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public ProductionBatch getBatch() {
        return batch;
    }

    public void setBatch(ProductionBatch productionBatch) {
        this.batch = productionBatch;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
