package softuni.exam.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "mountaineers")
@Getter
@Setter
@NoArgsConstructor
public class Mountaineer extends BaseEntity {

    @Column(name = "first_name", nullable = false, unique = true)
    private String firstName;

    @Column(name = "last_name", nullable = false, unique = true)
    private String lastName;

    @Column(name = "budget", nullable = false)
    private Double budget;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "mountaineer_from")
    private LocalDate mountaineerFrom;

    @ManyToOne
    @JoinColumn(name = "climbing_mountain_id")
    private Mountain mountain;
}
