package hibernate.entities;

public class Student {
    private long id;
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
