package com.antsim.creatures.ants;

import java.awt.Point;
import java.util.Random;


public class SoldierAnt extends Ant {
    private static final Random random = new Random();

    public SoldierAnt(Point position) {
        super(
            random.nextFloat() * 50 + 70, // 70-120
            random.nextFloat() * 20 + 30, // 30-50
            "soldier"
        );
        this.position = position;
    }

    @Override
    public void update() {
        hunger -= 0.15f;
        thirst -= 0.25f;

        // Логика патрулирования и атаки врагов
        wander(1);
    }
}