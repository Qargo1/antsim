package com.antsim.creatures.enemies;
// Примеры конкретных врагов

public class Spider extends Enemy {
    public Spider() {
        this.health = 120;
        this.attack = 30;
        this.defense = 10;
        this.moveSpeed = 2.5f;
        this.isHostile = true;
    }

    @Override
    public void update() {
        // Логика патрулирования территории
    }
}