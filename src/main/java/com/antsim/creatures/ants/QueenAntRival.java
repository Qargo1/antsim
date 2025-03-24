package com.antsim.creatures.ants;

import java.awt.Point;
import java.util.Random;
import com.antsim.world.WorldMap;


public class QueenAntRival extends Ant {
    private static final Random random = new Random();
    private int eggCooldown;
    private WorldMap map;

    public QueenAntRival(Point position) {
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
            layEgg(this.position.x+1, this.position.y+1);
            eggCooldown = random.nextInt(20) + 10;
        } else {
            eggCooldown--;
        }

        if (hunger <= 0 || thirst <= 0) {
            health -= 5;
        }

        wander(1);

        // this.findSafeSpot(map.getWallsAround(this.position));
    }

    private void layEgg(int x, int y) {
        Egg egg = new Egg(new Point(x, y), antManager);
        antManager.addEgg(egg);
    }
}