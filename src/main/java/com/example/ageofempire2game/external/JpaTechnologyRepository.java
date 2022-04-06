package com.example.ageofempire2game.external;

import com.example.ageofempire2game.domain.model.Technology;
import com.example.ageofempire2game.domain.repository.TechnologyRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTechnologyRepository extends JpaRepository<Technology, Integer>, TechnologyRepository {
}
