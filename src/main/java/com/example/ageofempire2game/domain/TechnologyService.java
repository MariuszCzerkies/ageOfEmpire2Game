package com.example.ageofempire2game.domain;

import com.example.ageofempire2game.domain.model.ResultTechnologies;
import com.example.ageofempire2game.domain.model.Technology;
import com.example.ageofempire2game.domain.repository.TechnologyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TechnologyService {

    private TechnologyRepository technologyRepository;

    public ResultTechnologies costAllResources(String age, String expansion) {
        List<Technology> technologyRepositoryAll = technologyRepository.findAll();
        List<Technology> filterTechnology = getTechnologiesBy(age, expansion, technologyRepositoryAll);
        ResultTechnologies result = new ResultTechnologies();
        filterTechnology
                  .forEach(technology -> result.add(technology.getBuildTime(), technology.getCost()));
        return result;
    }

    private List<Technology> getTechnologiesBy(String age, String expansion, List<Technology> technologyRepositoryAll) {
        List<Technology> filterTechnology;
        if (age.isEmpty()) {
            filterTechnology = technologyRepositoryAll;
        } else {
            filterTechnology = technologyRepositoryAll.stream()
                    .filter(technology -> technology.getAge().equals(age))
                    .collect(Collectors.toList());
        }
        if (!expansion.isEmpty()) {
            filterTechnology = filterTechnology.stream()
                    .filter(technology -> technology.getExpansion().equals(expansion))
                    .collect(Collectors.toList());
        }
        return filterTechnology;
    }
}
