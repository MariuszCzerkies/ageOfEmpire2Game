package com.example.ageofempire2game.domain.repository;

import com.example.ageofempire2game.domain.model.Technology;

import java.util.List;


public interface TechnologyRepository {

    Technology save(Technology technology);
    List<Technology> findAll();
}
