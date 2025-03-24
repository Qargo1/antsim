package com.antsim.creatures.ants;

import java.awt.Point;
import java.util.Random;

import com.antsim.creatures.Creature;
import com.antsim.world.GameWorld;

import lombok.Getter;
import lombok.Setter;


public class Egg extends Creature{
    private static final Random random = new Random();
    private @Getter @Setter int hatchTimer;
    private @Getter @Setter Point position;
    private @Getter @Setter String antType;
    private GameWorld gameWorld;

    public Egg(Point position, GameWorld gameWorld) {
        super();
        this.position = position;
        this.gameWorld = gameWorld;
        this.hatchTimer = random.nextInt(10) + 10;
    }

    @Override
    public void update() {
        hatchTimer--;
        if (hatchTimer <= 0) hatch();

        this.health -= 0.1;
    }

    private void hatch() {
        Ant newAnt = AntFactory.createAnt(antType, position);
        gameWorld.addCreature(newAnt);
    }

    private String generateAntType() {
        String[] types = {"worker", "soldier", "nurse", "builder"};
        return types[random.nextInt(types.length)];
    }
}