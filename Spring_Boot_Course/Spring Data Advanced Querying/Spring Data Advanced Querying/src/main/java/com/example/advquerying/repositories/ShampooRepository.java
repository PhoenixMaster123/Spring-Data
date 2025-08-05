package com.example.advquerying.repositories;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo,Long> {

    List<Shampoo> findBySizeOrderByBrandDesc(Size size);

    List<Shampoo> findBySizeOrLabelId(Size size, long labelId);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    Integer countByPriceLessThan(BigDecimal price);


    List<Shampoo> findByIngredientsNameIn(List<String> names);

    @Query("SELECT s FROM Shampoo s JOIN s.ingredients i WHERE i.name IN :names")
    List<Shampoo> findByIngredientsNameInQuery(List<String> names); // We can also use @Param("nameList") List<String> names;

    @Query("SELECT s FROM Shampoo s JOIN s.ingredients i GROUP BY s.id HAVING COUNT(i) < :count")
    // Variant 2: @Query("SELECT s FROM Shampoo s WHERE SIZE(s.ingredients) < :count")
    List<Shampoo> findByIngredientsCountLessThan(int count);
}

// findBy returns Optional<Shampoo>
// getBy returns Shampoo
