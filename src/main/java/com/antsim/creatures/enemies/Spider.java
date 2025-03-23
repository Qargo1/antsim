package com.antsim.creatures.enemies;
// Примеры конкретных врагов
import java.awt.Point;

public class Spider extends Enemy {
    public Spider(Point position) {
        this.health = 120;
        this.attack = 30;
        this.defense = 10;
        this.moveSpeed = 2.5f;
        this.isHostile = true;

        this.position = position;
        this.health = 50;
        this.attack = 20;
        this.defense = 10;
    }

    @Override
    public void update() {
        wander(1); // Случайное движение
    }
}