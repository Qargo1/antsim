package com.antsim.creatures.enemies;

import java.awt.Point;


public class Beetle extends Enemy {
    public Beetle() {
        this.health = 30;
        this.attack = 10;
        this.defense = 5;

        this.speed = 2;

        this.moveSpeed = 2.5f;
        this.isHostile = true;
    }

    public Beetle(Point position) {
        super(position);
        this.health = 30;
        this.attack = 10;
        this.defense = 5;

        this.speed = 2;

        this.moveSpeed = 2.5f;
        this.isHostile = true;
    }

    @Override
    public void update() {
        // Логика патрулирования территории
    }
}