package com.antsim.creatures.ants;
import java.util.Random;


public class WorkerAnt extends Ant{
    public WorkerAnt() {
        // Генерация attack: 50-80, defense: 40-70
        super(
            new Random().nextFloat() * 30 + 50, // 50 + [0..30)
            new Random().nextFloat() * 30 + 40,  // 40 + [0..30)
            "worker"
        );
    }

    @Override
    public void update() {
        hunger -= 0.1f;
        thirst -= 0.2f;
    }
}
