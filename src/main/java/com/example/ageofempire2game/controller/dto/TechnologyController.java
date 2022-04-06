package com.example.ageofempire2game.controller.dto;

import com.example.ageofempire2game.domain.TechnologyService;
import com.example.ageofempire2game.domain.model.ResultTechnologies;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/technology", consumes = "application/json", produces = "application/json")
public class TechnologyController {

    private TechnologyService technologyService;

    @GetMapping()
    public ResponseEntity<ResultTechnologies> getAgeAndExpansion(
            @RequestParam(name = "age", required = false, defaultValue = "") String age,
            @RequestParam(name = "expansion", required = false,  defaultValue = "") String expansion
    ) {
        return ResponseEntity.ok(technologyService.costAllResources(age, expansion));
    }
}