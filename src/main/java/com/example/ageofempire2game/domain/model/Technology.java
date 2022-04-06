package com.example.ageofempire2game.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(exclude = "id")
public class Technology {

    @Id
    private Integer id;

    private String name;
    private String description;
    private String expansion;
    private String age;
    private String develops_in;
    @Embedded//wbudowana
    private Cost cost;
    @JsonProperty("build_time")
    private Integer buildTime;
    @ElementCollection
    private List<String> applies_to;

}
