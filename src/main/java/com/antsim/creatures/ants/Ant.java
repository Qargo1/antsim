package com.antsim.creatures.ants;
import com.antsim.creatures.Creature;

import com.antsim.world.worldItems.*;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;


public abstract class Ant extends Creature{
    protected Random random = new Random();
    protected boolean foodIsLoaded;
    protected @Getter float foodCapacity;
    protected @Setter @Getter float hunger;
    protected @Setter @Getter float thirst;
    protected AntManager antManager;

    public Ant(Float attack, Float defense, String type) {
        super();
        float[] stats = this.generateStats();
        this.attack = attack;
        this.defense = defense;
        this.type = type;
        this.health = stats[2];
        this.hunger = stats[3];
        this.thirst = stats[4];
        this.foodIsLoaded = false;
        this.foodCapacity = 0;
    }

    public Ant(String type) {
        float[] stats = this.generateStats();
        this.attack = stats[0];
        this.defense = stats[1];
        this.health = stats[2];
        this.hunger = stats[3];
        this.thirst = stats[4];
        this.type = type;
        this.foodIsLoaded = false;
        this.foodCapacity = 0;
    }

    private float[] generateStats() {
        float[] stats = new float[5];
        for (int i = 0; i < stats.length; i++) {
            stats[i] = random.nextFloat() * 100;
        }
        return stats;
    }

    public void setFoodCapacity(float capacity) {
        if (capacity >=0) {
            foodIsLoaded = true;
            foodCapacity = capacity;
        }
    }

    public void waterCarried(Water water) {
    }

    public void stuffCarried(Stuff stuff) {
    }

    // abstract must go before void
    @Override
    public void update() {
        if (foodIsLoaded) {
            if (health < 100) {
                float healthNeeded = 100 - health;
                if (foodCapacity > healthNeeded) {
                    health = healthNeeded;
                    foodCapacity = foodCapacity - healthNeeded;
                    // this.shareFood(nearbyAnt);
                } else if (foodCapacity < healthNeeded) {
                    health = foodCapacity;
                    foodIsLoaded = false;
                }
            }
        }
    }
}
