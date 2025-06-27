package lab.TablePerClassStrategy.models;

import jakarta.persistence.*;

/*
@MappedSuperclass is a special JPA annotation used when you want to define
common fields and mappings in a base class,
but don’t want that class to be an entity itself.

Use Case:
===========
You want to share fields like id, createdAt, etc.,
across multiple entities — without duplicating code —
but you don't want the superclass to be stored as a separate table.
 */

@MappedSuperclass // This class will not be an entity itself, but its fields will be inherited by subclasses.
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private boolean isDeleted;
}
