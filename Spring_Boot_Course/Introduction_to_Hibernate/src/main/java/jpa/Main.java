package jpa;

import hibernate.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-emf");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = new Student();
        student.setName("John Doe");
        entityManager.persist(student);

        // NOTE: Create JPA and Hibernate XML in different projects and not in one
    }
}
