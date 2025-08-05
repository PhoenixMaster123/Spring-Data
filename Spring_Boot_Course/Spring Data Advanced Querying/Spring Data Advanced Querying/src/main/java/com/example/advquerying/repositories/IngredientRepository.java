package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    List<Ingredient> findByNameStartingWith(String prefix);

    List<Ingredient> findByNameInOrderByPrice(List<String> names);

    //@Transactional // This annotation is not needed here, as the delete operation will be handled by the service layer
    void deleteByName(String name);

    @Modifying
    @Transactional
    @Query ("UPDATE Ingredient AS i SET i.price = i.price * (1 + :percentage / 100)")
    void updatePriceByPercentage(double percentage);

    @Modifying
    @Transactional
    @Query("UPDATE Ingredient AS i SET i.price = i.price * (1 + :percentage / 100) WHERE i.name IN :names")
    void updatePriceByName(double percentage, List<String> names);
}
