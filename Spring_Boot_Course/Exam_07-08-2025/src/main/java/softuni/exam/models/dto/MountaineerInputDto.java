package softuni.exam.models.dto;

import jakarta.validation.constraints.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import softuni.exam.config.LocalDateAdapter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class MountaineerInputDto {
    @XmlElement(name = "first_name")
    @NotNull
    @Length(min = 2, max = 30)
    private String firstName;

    @XmlElement(name = "last_name")
    @NotNull
    @Length(min = 2, max = 30)
    private String lastName;

    @XmlElement(name = "budget")
    @NotNull
    @Positive
    private Double budget;

    @XmlElement(name = "age")
    @Min(value = 18)
    @Max(value = 80)
    private Integer age;

    @XmlElement(name = "mountaineer_from")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate mountaineerFrom;

    @XmlElement(name = "climbing_mountain_id")
    private Long mountain_id;
}
