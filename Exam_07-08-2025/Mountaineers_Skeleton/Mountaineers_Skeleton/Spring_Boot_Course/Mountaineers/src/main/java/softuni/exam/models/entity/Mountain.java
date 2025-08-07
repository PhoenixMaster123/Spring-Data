package softuni.exam.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.enums.ElevationCategory;

@Entity
@Table(name = "mountains")
@Getter
@Setter
@NoArgsConstructor
public class Mountain extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "elevation", nullable = false)
    private Integer elevation;

    @Column(name = "elevation_category")
    @Enumerated(EnumType.STRING)
    private ElevationCategory elevationCategory;

    @Column(name = "hard_to_reach", nullable = false)
    private Boolean hardToReach;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
