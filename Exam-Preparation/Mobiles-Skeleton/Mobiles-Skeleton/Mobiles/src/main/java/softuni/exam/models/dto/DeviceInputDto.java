package softuni.exam.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import softuni.exam.models.entity.DeviceType;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceInputDto {
    @XmlElement(name = "brand")
    @NotNull
    @Length(min = 2, max = 20)
    private String brand;

    @XmlElement(name = "device_type")
    private DeviceType deviceType;

    @XmlElement(name = "model")
    @NotNull
    @Length(min = 1, max = 20)
    private String model;

    @XmlElement(name = "price")
    @Positive
    private Double price;

    @XmlElement(name = "storage")
    @Positive
    private Integer storage;

    @XmlElement(name = "sale_id")
    private Long sale;
}
