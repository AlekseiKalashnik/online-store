package com.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.onlinestore.entity.Classifier;
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
    private String name;

    @JsonProperty(value = "Classifier")
    private Classifier classifier;
}
