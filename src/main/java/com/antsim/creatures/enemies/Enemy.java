package com.antsim.creatures.enemies;

// Базовый класс врага
import com.antsim.creatures.ants.Ant;
import com.antsim.creatures.Creature;
import lombok.Getter;
import lombok.Setter;
import java.awt.Point;


// @Data // Автоматически генерирует геттеры/сеттеры
public abstract class Enemy extends Creature {
    protected @Getter boolean isHostile;
    protected @Getter @Setter float moveSpeed;

    public Enemy(Point position) {
        super(position);
    }

    public Enemy() {
    }

    public void attack(Ant target) {
        target.setHealth(this.attack * (1 - target.getDefense()/100));
    }
}

// Остальные враги по аналогии: Wasp, Antlion, Centipede...