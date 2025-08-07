package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import softuni.exam.models.entity.enums.ElevationCategory;

@Getter
@Setter
@NoArgsConstructor
public class MountainInputDto {
    @Expose
    @NotNull
    @Length(min = 2, max = 30)
    private String name;

    @Expose
    @Positive
    @NotNull
    @Max(9999)
    private Integer elevation;

    @Expose
    private ElevationCategory elevationCategory;

    @Expose
    @NotNull
    private Boolean hardToReach;

    @Expose
    private Long country_id;
}
