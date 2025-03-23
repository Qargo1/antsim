package com.antsim.creatures.ants;

import java.awt.Point;
import java.util.Random;
import com.antsim.world.GameWorld;


public class QueenAnt extends Ant {
    private static final Random random = new Random();
    private int eggCooldown;
    private GameWorld gameWorld;

    public QueenAnt(Point position, GameWorld gameWorld) {
        super(
            random.nextFloat() * 20 + 10, // 10-30
            random.nextFloat() * 10 + 80,  // 80-90
            "queen"
        );
        this.position = position;
        this.health = 100;
        this.eggCooldown = random.nextInt(20) + 10;
        this.gameWorld = gameWorld;
    }

    public QueenAnt(Point position) {
        super(
            random.nextFloat() * 20 + 10, // 10-30
            random.nextFloat() * 10 + 80,  // 80-90
            "queen"
        );
        this.position = position;
        this.health = 100;
        this.eggCooldown = random.nextInt(20) + 10;
    }

    @Override
    public void update() {
        hunger -= 0.2f;
        thirst -= 0.3f;

        if (eggCooldown <= 0) {
            layEgg();
            eggCooldown = random.nextInt(20) + 10;
        } else {
            eggCooldown--;
        }

        if (hunger <= 0 || thirst <= 0) {
            health -= 5;
        }

        wander(1);
    }

    private void layEgg() {
        Egg egg = new Egg(new Point(position.x, position.y), gameWorld);
        gameWorld.addEgg(egg);
    }
}