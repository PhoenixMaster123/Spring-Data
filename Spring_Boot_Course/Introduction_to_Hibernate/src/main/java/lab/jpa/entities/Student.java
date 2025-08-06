package lab.jpa.entities;

import jakarta.persistence.*;

@Entity(name = "StudentJPA") // Optional: specify a custom entity name
@Table(name = "students_jpa") // Specify the table name in the database
public class Student {
    @Id // Primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing primary key
    @Column(name = "student_id") // Specify the column name in the database
    private long id;

    @Column(name = "student_name", length = 50)
    private String name;

    // Default constructor
    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
