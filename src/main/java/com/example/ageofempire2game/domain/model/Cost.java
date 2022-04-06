package com.example.ageofempire2game.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Cost {

    @JsonProperty
    private Integer Wood;

    @JsonProperty
    private Integer Food;

    @JsonProperty
    private Integer Stone;

    @JsonProperty
    private Integer Gold;
}
