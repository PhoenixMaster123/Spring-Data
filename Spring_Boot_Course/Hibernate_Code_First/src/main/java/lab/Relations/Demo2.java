package lab.Relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import lab.Relations.models.Ingredient;
import lab.Relations.models.Label;
import lab.Relations.models.ProductionBatch;
import lab.Relations.models.Shampoo;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Demo2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("labs");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Label label = new Label();
        label.setName("Freshness");
        //em.persist(label);

        ProductionBatch batch = new ProductionBatch();
        batch.setDate(LocalDate.now());
        //em.persist(batch);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Aloe Vera");
        //em.persist(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Coconut Oil");
        // em.persist(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName("Tea Tree Oil");
        //em.persist(ingredient3);

        Shampoo shampoo = new Shampoo();
        shampoo.setBrand("Herbal Essence");
        shampoo.setLabel(label);
        shampoo.setBatch(batch);
        shampoo.setIngredients(Set.of(ingredient1, ingredient2, ingredient3));
        //em.persist(shampoo);


        em.getTransaction().commit();

        em.clear();  // Clear the persistence context

        TypedQuery<Shampoo> shampooQuery = em.createQuery("SELECT s FROM Shampoo s", Shampoo.class);
        List<Shampoo> shampoos = shampooQuery.getResultList();

        for (Shampoo s : shampoos) {
            System.out.printf("Shampoo Brand: %s, Label: %s, Batch Date: %s, Ingredients: %s%n",
                    s.getBrand(),
                    s.getLabel().getName(),
                    s.getBatch().getDate(),
                    s.getIngredients().stream()
                            .map(Ingredient::getName)
                            .reduce((a, b) -> a + ", " + b)
                            .orElse("No ingredients"));

            // Fetching Strategies
            // 1. EAGER: All related entities are fetched immediately.
            // Eager → retrieves all reachable entity objects immediately when the entity is fetched
            // 2. LAZY: Related entities are fetched on demand.
            // Lazy → retrieves all reachable entity objects only when fetched entity's getter method is called
            // Note: The default fetching strategy for @ManyToMany is LAZY.
            // To change the fetching strategy, you can use the @ManyToMany(fetch = FetchType.EAGER) annotation.

            //Lazy is default by collection

            // Cascade Types
            // CascadeType.PERSIST: When the parent entity is persisted, the child entities are also persisted.
            // CascadeType.MERGE: When the parent entity is merged, the child entities are also merged.
            // CascadeType.REMOVE: When the parent entity is removed, the child entities are also removed.
            // CascadeType.DETACH: When the parent entity is detached, the child entities are also detached.
            // CascadeType.ALL: All cascade operations are applied to the child entities.

        }
    }
}
