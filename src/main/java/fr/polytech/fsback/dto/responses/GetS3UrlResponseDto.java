package fr.polytech.fsback.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetS3UrlResponseDto {

    @JsonProperty("url")
    private String url;

    public static GetS3UrlResponseDto fromEntity(String url) {
        return GetS3UrlResponseDto.builder().url(url).build();
    }

}
