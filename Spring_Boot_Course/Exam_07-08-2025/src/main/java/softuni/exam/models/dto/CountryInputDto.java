package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class CountryInputDto {
    @Expose
    @NotNull
    @Length(min = 3, max = 30)
    private String name;

    @Expose
    @Length(min = 3, max = 30)
    private String capital;
}
