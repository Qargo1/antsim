package com.antsim.creatures.ants;

import java.awt.Point;
import java.util.Random;
import com.antsim.world.WorldMap;


public class WorkerAnt extends Ant {
    private Point target;
    private WorldMap map;

    public WorkerAnt(Point position, WorldMap map) {
        super(
            new Random().nextFloat() * 30 + 50,
            new Random().nextFloat() * 30 + 40,
            "worker"
        );
        this.position = position;
        this.map = map;
        this.target = findDigTarget();
    }

    public WorkerAnt(Point position) {
        super(
            new Random().nextFloat() * 30 + 50,
            new Random().nextFloat() * 30 + 40,
            "worker"
        );
        this.position = position;
        this.target = findDigTarget();
    }

    @Override
    public void update() {
        if (target != null) {
            moveTo(target, 1);
            if (position.equals(target)) {
                map.digTunnel(target.x, target.y);
                target = findDigTarget();
            }
        }
        wander(1);
    }

    private Point findDigTarget() {
        // Логика поиска цели для копания
        return new Point(position.x + 1, position.y);
    }
}