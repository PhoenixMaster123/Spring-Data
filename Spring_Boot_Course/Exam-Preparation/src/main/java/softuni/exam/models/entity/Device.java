package softuni.exam.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "devices")
public class Device extends BaseEntity {

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "device_type")
    @Enumerated(EnumType.STRING)
    DeviceType deviceType;

    @Column(name = "model", nullable = false, unique = true)
    private String model;

    @Column(name = "price")
    private Double price;

    @Column(name = "storage")
    private Integer storage;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale_id;

    public Device() {}

}
