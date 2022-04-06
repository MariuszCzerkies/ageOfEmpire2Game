package com.example.ageofempire2game.domain.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResultTechnologies {
    private Map<String, Integer> stringMap;
    private Integer buildTime;

    public void add(Integer builldT, Cost cost) {
        addBuiltTime(builldT);
        addResourcesFromCost("wood", cost.getWood());
        addResourcesFromCost("gold", cost.getGold());
        addResourcesFromCost("stone", cost.getStone());
        addResourcesFromCost("food", cost.getFood());

    }

    private void addResourcesFromCost(String key, Integer resourcesCost) {
        if (stringMap == null) {
            stringMap = new HashMap<>();
        }
        if (resourcesCost != null) {
            if (stringMap.containsKey(key)) {
                stringMap.put(key, stringMap.get(key) + resourcesCost);
            } else {
                stringMap.put(key, resourcesCost);
            }
        }
    }

    private void addBuiltTime(Integer timeeeee ) {
        if (buildTime == null) {
            buildTime = 0;
        }
        buildTime = buildTime + timeeeee;
    }
}
