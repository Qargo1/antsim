package com.antsim.creatures.ants;

import java.awt.Point;
import java.util.Random;

public class NurseAnt extends Ant {
    private static final Random random = new Random();

    public NurseAnt(Point position) {
        super(
            random.nextFloat() * 10 + 20, // 20-30
            random.nextFloat() * 10 + 20, // 20-30
            "nurse"
        );
        this.position = position;
    }

    @Override
    public void update() {
        hunger -= 0.1f;
        thirst -= 0.2f;

        // Логика лечения других муравьев
        wander(1);
    }
}