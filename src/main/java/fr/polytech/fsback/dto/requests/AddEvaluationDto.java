package fr.polytech.fsback.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEvaluationDto {

    @JsonProperty("evaluateur")
    @Size(max = 50)
    private String evaluateur;

    @JsonProperty("commentaire")
    @Size(max = 255)
    private String commentaire;

    @JsonProperty("note")
    @Min(0)
    @Max(3)
    private int note;

}
