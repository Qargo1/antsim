package com.antsim.creatures.enemies;
// Примеры конкретных врагов
import java.awt.Point;

public class Spider extends Enemy {
    public Spider() {
        this.health = 50;
        this.attack = 15;
        this.defense = 15;
        this.moveSpeed = 1.5f;
        this.isHostile = true;
    }

    public Spider(Point position) {
        super(position);
        this.health = 50;
        this.attack = 15;
        this.defense = 15;
        this.moveSpeed = 1.5f;
        this.isHostile = true;
    }

    @Override
    public void update() {
        wander(1); // Случайное движение
    }
}