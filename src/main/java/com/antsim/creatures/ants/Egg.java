package com.antsim.creatures.ants;

import java.awt.Point;
import java.util.Random;

import com.antsim.creatures.Creature;

import lombok.Getter;
import lombok.Setter;


public class Egg extends Creature{
    private static final Random random = new Random();
    private final AntManager antManager; // Добавляем ссылку
    private @Getter @Setter int hatchTimer;
    private @Getter @Setter Point position;
    private @Getter @Setter String antType;

    public Egg(Point position, AntManager antManager) {
        super();
        this.antManager = antManager;
        this.position = position;
        this.hatchTimer = random.nextInt(10) + 10;
    }

    @Override
    public void update() {
        hatchTimer--;
        if (hatchTimer <= 0) hatch();

        this.health -= 0.1;
    }

    private void hatch() {
        Ant newAnt = antManager.createAnt(generateAntType(), position);
        antManager.addAnt(newAnt);
    }

    private String generateAntType() {
        String[] types = {"worker", "soldier", "nurse", "builder"};
        return types[random.nextInt(types.length)];
    }
}