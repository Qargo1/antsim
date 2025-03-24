package com.antsim.creatures.ants;

import java.awt.Point;
import java.util.Random;


public class BuilderAnt extends Ant {
    private static final Random random = new Random();

    public BuilderAnt(Point position) {
        super(
            random.nextFloat() * 20 + 30, // 30-50
            random.nextFloat() * 20 + 40, // 40-60
            "builder"
        );
        this.position = position;
    }

    @Override
    public void update() {
        hunger -= 0.1f;
        thirst -= 0.2f;

        // Логика постройки/ремонта туннелей
        wander(1);
    }
}