package com.antsim.creatures.enemies;


// EnemyType.java
public enum EnemyType {
    SPIDER(0.3), WASP(0.3), BEETLE(0.2), RHINOBEETLE(0.1), ANTLION(0.1);

    private final double spawnChance;
    
    // конструктор и геттер

    EnemyType(double spawnChance) {
        this.spawnChance = spawnChance;
    }

    public static EnemyType getRandomType() {
        double rand = Math.random();
        double cumulative = 0;
        for (EnemyType type : values()) {
            cumulative += type.spawnChance;
            if (rand <= cumulative) return type;
        }
        return SPIDER;
    }
}