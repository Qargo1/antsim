package com.antsim.creatures.enemies;

import java.awt.Point;


public class RhinoBeetle extends Enemy {
    public RhinoBeetle() {
        this.speed = 1;
        this.attack = 7;
        this.health = 90;
        this.moveSpeed = 0.5f;
        this.isHostile = true;
        this.defense = 90;
    }

    public RhinoBeetle(Point position) {
        super(position);
        this.speed = 1;
        this.attack = 7;
        this.health = 90;
        this.moveSpeed = 0.5f;
        this.isHostile = true;
        this.defense = 90;
    }

    @Override
    public void update() {

    }
}
