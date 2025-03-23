package com.antsim.creatures.enemies;


public class Beetle extends Enemy {
    public Beetle() {
        this.health = 200;
        this.attack = 15;
        this.defense = 40; // Толстый панцирь
    }

    @Override
    public void update() {
        // Логика патрулирования территории
    }
}