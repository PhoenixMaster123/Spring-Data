# Spring Boot Annotations Overview

## Core Annotations

| Annotation      | Layer / Purpose               | Description                                                                                                                                 |
|------------------|-------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| `@Component`     | Generic (All Layers)          | Marks a class as a Spring-managed component. Enables component scanning and dependency injection.                                          |
| `@Service`       | Service Layer                 | Specialization of `@Component`. Indicates that the class holds business logic. Automatically discovered by Spring.                         |
| `@Repository`    | Persistence Layer (DAO)       | Specialization of `@Component`. Enables exception translation for database operations.                                                     |

---

## Dependency Injection

| Annotation    | Purpose                                                                                       |
|---------------|-----------------------------------------------------------------------------------------------|
| `@Autowired`  | Injects a Spring-managed bean by type. Can be used on constructors, fields, or setters.       |

---

## Persistence & ORM (JPA / Hibernate)

| Annotation           | Purpose                                                                                      |
|----------------------|----------------------------------------------------------------------------------------------|
| `@Entity`            | Marks a class as a JPA entity. Maps to a database table.                                     |
| `@Table`             | Specifies the database table name for an entity (optional, defaults to class name).          |
| `@Id`                | Specifies the primary key of an entity.                                                      |
| `@GeneratedValue`    | Defines how the primary key is generated (e.g., auto-increment).                             |
| `@Column`            | Specifies column properties (e.g., name, length, nullable).                                  |
| `@MappedSuperclass`  | Allows fields to be inherited by JPA entities. Used for abstract base classes.               |
| `@Enumerated`        | The @Enumerated annotation in Spring Data JPA (from the JPA specification) is used to specify how an enum should be persisted in the database. |
| `@Param`             | The @Param annotation in Spring Data JPA is used to bind method parameters to named parameters in a JPQL or native query defined with @Query.  |

NOTE:
EnumType.ORDINAL	Stores the ordinal (integer index, starting at 0). <br>
EnumType.STRING	Stores the name of the enum constant (as a string) (recommended).

Problem: if you add a new enum constant, the index of the existing constants will change (EnumType.ORDINAL) <br>
Problem: if you rename an enum constant, the value in the database will not change (EnumType.STRING)

---

## Relationships

| Annotation       | Description                                              |
|------------------|----------------------------------------------------------|
| `@OneToOne`      | Defines a one-to-one relationship between two entities. |
| `@OneToMany`     | Defines a one-to-many relationship (one entity to many).|
| `@ManyToOne`     | Defines a many-to-one relationship (many entities to one).|
| `@ManyToMany`    | Defines a many-to-many relationship between entities.    |
| `@JoinColumn`    | Specifies the foreign key column in a relationship.      |
| `@JoinTable`     | Specifies a join table for many-to-many relationships.   |

---

## Transactions & Queries

| Annotation         | Purpose                                                                                       |
|--------------------|-----------------------------------------------------------------------------------------------|
| `@Transactional`   | Marks a method or class to be executed within a transaction. Required for update/delete.      |
| `@Modifying`       | Indicates that the annotated method modifies data (used with update/delete queries).          |
| `@Query`           | Allows the definition of custom JPQL or native SQL queries.                                   |
| `@NamedQuery`      | Declares a static named JPQL query at the entity level.                                       |

---

## Repository Design Tips

### Repository Inheritance

If you find yourself repeating methods like `findByName(String name)` across multiple repositories, create a base repository interface with common methods and annotate it with `@NoRepositoryBean` to avoid Spring instantiating it directly.

**Example:**

```java
@NoRepositoryBean
public interface IngredientRepository<T extends Ingredient> extends JpaRepository<T, Long> {
    List<T> findByName(String name);
}
Then extend it in your specific repositories:
@Repository
public interface ChemicalIngredientRepository extends IngredientRepository<BasicChemicalIngredient> {
    List<ChemicalIngredient> findByChemicalFormula(String chemicalFormula);
}
```
