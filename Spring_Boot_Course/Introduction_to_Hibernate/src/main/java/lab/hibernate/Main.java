package lab.hibernate;

import lab.hibernate.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();

        SessionFactory factory = config.buildSessionFactory();
        Session session  = factory.openSession();

        session.getTransaction().begin();

        //Student student = new Student();
        //student.setName("John Doe");

        //session.persist(student);

        Student found = session.find(Student.class, 1);
        System.out.println(found.getName());

        session.getTransaction().commit();
        session.close();
    }
}
