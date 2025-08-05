# Spring Boot Annotations Overview

| Annotation    | Layer / Purpose                          | Description                                                                                               |
|---------------|------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| `@Component`  | Generic / All layers                     | Marks a class as a Spring-managed component. Enables component scanning and dependency injection.         |
| `@Service`    | Service layer                            | Specialization of `@Component` for service layer. Holds business logic and is auto-detected by Spring.    |
| `@Repository` | Persistence / Data access layer          | Specialization of `@Component` for DAOs. Enables exception translation for database operations.           |
| `@Autowired`  | Dependency injection (all layers)        | Injects a Spring-managed bean automatically by type into another bean. Can be used on fields, setters, or constructors. |
| `@Entity`     | Persistence / ORM layer                  | Marks a class as a JPA entity. Indicates that the class maps to a database table for ORM (Object-Relational Mapping). |

> `@Service` and `@Repository` are specialized versions of `@Component` used to indicate the role of the class in the application.
