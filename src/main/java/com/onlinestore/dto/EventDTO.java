package com.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.onlinestore.entity.Classifier;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    @JsonProperty(value = "Event name")
    @NotBlank(message = "Field can't be empty")
    @Schema(description = "Event name", example = "Movie")
    @Size(min = 1, max = 50, message = "length must contains from 1 to 50 characters")
    private String name;

    @Enumerated(EnumType.STRING)
    @JsonProperty(value = "Classifier")
    @Schema(description = "Classifier", example = "NOTE")
    private Classifier classifier;
}
