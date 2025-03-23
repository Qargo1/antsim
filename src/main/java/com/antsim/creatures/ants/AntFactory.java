package com.antsim.creatures.ants;

import java.awt.Point;


public class AntFactory {
    public static Ant createAnt(String type, Point position) {
        return switch (type.toLowerCase()) {
            case "worker" -> new WorkerAnt(position);
            case "queen" -> new QueenAnt(position);
            case "soldier" -> new SoldierAnt(position);
            case "nurse" -> new NurseAnt(position);
            case "builder" -> new BuilderAnt(position);
            default -> throw new IllegalArgumentException("Неизвестный тип муравья: " + type);
        };
    }
}