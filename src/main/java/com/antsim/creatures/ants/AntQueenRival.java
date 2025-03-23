package com.antsim.creatures.ants;
import com.antsim.creatures.enemies.Enemy;


public class AntQueenRival extends Enemy {
    private boolean hasEggs;
    
    public AntQueenRival() {
        this.health = 500;
        this.attack = 10;
        this.defense = 70;
    }

    @Override
    public void update() {
        if (health < 100 && !hasEggs) {
            spawnAnts(); // Создает муравьев-защитников
            hasEggs = true;
        }
    }

    private void spawnAnts() {
        // Логика спавна (потребует доступа к AntColony)
    }
}