package com.antsim.creatures.ants;
import java.util.Random;

public class QueenAnt extends Ant{
    boolean isLayedEgg = true;

    public QueenAnt() {
        // Генерация attack: 10-30, defense: 80-90
        super(
            new Random().nextFloat() * 20 + 10, // 10 + [0..20)
            new Random().nextFloat() * 10 + 80,  // 80 + [0..10)
            "queen"
        );
    }

    @Override
    public void update() {
        if (this.isLayedEgg) {
            hunger -= 0.4f;
            thirst -= 0.6f;
        }
        hunger -= 0.2f;
        thirst -= 0.3f;
    }
}
