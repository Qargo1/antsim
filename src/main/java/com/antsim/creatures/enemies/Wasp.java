package com.antsim.creatures.enemies;

import java.awt.Point;


public class Wasp extends Enemy {
    public Wasp() {
        this.speed = 3; // Быстрее обычных муравьев
        this.attack = 15;
        this.health = 10;
        this.defense = 5;
        this.moveSpeed = 2.5f;
        this.isHostile = true;
    }

    public Wasp(Point position) {
        super(position);
        this.speed = 3; // Быстрее обычных муравьев
        this.attack = 15;
        this.health = 10;
        this.defense = 5;
        this.moveSpeed = 2.5f;
        this.isHostile = true;
    }

    @Override
    public void update() {

    }
}
