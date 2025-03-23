package com.antsim.creatures.ants;
import com.antsim.creatures.enemies.Enemy;
import java.awt.Point;


public class AntQueenRival extends Enemy {
    private boolean hasEggs;
    private boolean hasTarget;
    private Point target = new Point();
    
    public AntQueenRival() {
        this.health = 500;
        this.attack = 10;
        this.defense = 70;
    }

    public void setHasTarget(boolean hasTarget) {
        this.hasTarget = hasTarget;
    }

    public void setTarget(Point target) {
        this.target = target;
    }

    @Override
    public void update() {
        if (health < 100 && !hasEggs) {
            spawnAnts(); // Создает муравьев-защитников
            hasEggs = true;
        }
        if (this.hasTarget) {
            moveTo(this.target, 2); // Быстрое движение к цели
        } else {
            wander(1); // Медленное блуждание
        }
    }

    private void spawnAnts() {
        // Логика спавна (потребует доступа к AntColony)
    }
}