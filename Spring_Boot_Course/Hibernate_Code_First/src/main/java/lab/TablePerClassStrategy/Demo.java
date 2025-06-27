package lab.TablePerClassStrategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import lab.TablePerClassStrategy.models.*;

import java.math.BigDecimal;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("labs");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Bike bike = new Bike();
        bike.setModel("Yamaha");
        em.persist(bike);

        Car car = new Car();
        car.setModel("BMW");
        car.setSeats(5);
        car.setFuelType("Diesel");
        car.setPrice(BigDecimal.valueOf(30000));
        em.persist(car);

        Plane plane = new Plane();
        plane.setModel("Boeing 747");
        plane.setPassengerCapacity(400);
        plane.setFuelType("Jet Fuel");
        em.persist(plane);

        Truck truck = new Truck();
        truck.setModel("Volvo FH");
        truck.setFuelType("Diesel");
        truck.setLoadCapacity(2.5);
        em.persist(truck);

        em.getTransaction().commit();

        TypedQuery<Vehicle> query = em.createQuery("SELECT v FROM Vehicle v", Vehicle.class);
        List<Vehicle> result = query.getResultList();

        System.out.println(result.size());

        // Strategy: TABLE_PER_CLASS

        // Note: In TABLE_PER_CLASS strategy, each subclass is stored in its own table.
        // They do not share a common table, so the query will return all vehicles
        // from all tables, but they are not joined in a single table.

        // They are not foreign key linked, so you cannot query them as a single table.

        // ---------------------------------------------------------------------------------- //

        // Strategy: JOINED

        // In JOINED strategy, all subclasses share a common table for the base class,
        // and each subclass has its own table for additional fields.
        // The query will return all vehicles from the base table and their respective subclass tables.
        // They are foreign key linked, so you can query them as a single table.

        // You need to change the inheritance strategy in the Vehicle class to JOINED:
        // @Inheritance(strategy = InheritanceType.JOINED)
        // We can use @GeneratedValue(strategy = GenerationType.IDENTITY) for the ID field in the Vehicle class
        // Or use @GeneratedValue(strategy = GenerationType.TABLE) if you want to keep the TABLE strategy for inheritance.

        // ---------------------------------------------------------------------------------- //

        // Strategy: SINGLE_TABLE (The best performance and the most efficient strategy)
        // In SINGLE_TABLE strategy, all subclasses are stored in a single table.
        // The table has a discriminator column to differentiate between subclasses.
        // You need to change the inheritance strategy in the Vehicle class to SINGLE_TABLE:
        // @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
        // We can use @GeneratedValue(strategy = GenerationType.IDENTITY) for the ID field in the Vehicle class
        // Or use @GeneratedValue(strategy = GenerationType.TABLE) if you want to keep the TABLE strategy for inheritance.

    }
}
