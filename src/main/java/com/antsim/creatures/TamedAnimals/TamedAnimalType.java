package com.antsim.creatures.tamedAnimals;


public enum TamedAnimalType {
    APHID(0.3), EARTHWORM(0.7);

    private final double spawnChance;
    
    // конструктор и геттер

    TamedAnimalType(double spawnChance) {
        this.spawnChance = spawnChance;
    }

    public static TamedAnimalType getRandomType() {
        double rand = Math.random();
        double cumulative = 0;
        for (TamedAnimalType type : values()) {
            cumulative += type.spawnChance;
            if (rand <= cumulative) return type;
        }
        return EARTHWORM;
    }
}