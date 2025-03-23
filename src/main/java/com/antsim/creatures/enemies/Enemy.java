package com.antsim.creatures.enemies;
// Базовый класс врага
import com.antsim.creatures.ants.Ant;
import com.antsim.creatures.Creature;


// @Data // Автоматически генерирует геттеры/сеттеры
public abstract class Enemy extends Creature {
    protected boolean isHostile;
    protected float moveSpeed;

    public void attack(Ant target) {
        target.setHealth(this.attack * (1 - target.getDefense()/100));
    }
}

// Остальные враги по аналогии: Wasp, Antlion, Centipede...