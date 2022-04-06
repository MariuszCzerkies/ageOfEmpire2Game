package com.example.ageofempire2game;

import com.example.ageofempire2game.domain.model.TechnologiesData;
import com.example.ageofempire2game.domain.repository.TechnologyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@AllArgsConstructor
public class SaveData implements CommandLineRunner {

    private final ObjectMapper objectMapper;
    private final TechnologyRepository repository;

//    @Override
//    public void run(String... args) throws Exception {
//        File file = new ClassPathResource("/data/dataTechnologies.json").getFile();
//
//        for (String text : Files.readAllLines(Path.of(file.getPath()))) {
//            System.out.println(text);
//        }
//    }

    public void run(String... args) {
        TechnologiesData technologyList;
        try {
            technologyList = objectMapper.readValue(readDataFile(), TechnologiesData.class);
            technologyList.getTechnologies()
                    .forEach(technology -> {
                        repository.save(technology);
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private File readDataFile() throws IOException {
        return new ClassPathResource("data/dataTechnologies.json").getFile();
    }
}
