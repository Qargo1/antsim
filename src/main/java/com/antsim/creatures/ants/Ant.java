package com.antsim.creatures.ants;
import com.antsim.creatures.Creature;
import java.util.Random;


public abstract class Ant extends Creature{
    protected Random random = new Random();
    protected float hunger;
    protected float thirst;
    String antType;

    public Ant(Float attack, Float defense, String antType) {
        super();
        float[] stats = this.generateStats();
        this.attack = attack;
        this.defense = defense;
        this.health = stats[2];
        this.hunger = stats[3];
        this.thirst = stats[4];
        this.antType = antType;
    }

    public Ant(String antType) {
        float[] stats = this.generateStats();
        this.attack = stats[0];
        this.defense = stats[1];
        this.health = stats[2];
        this.hunger = stats[3];
        this.thirst = stats[4];
        this.antType = antType;
    }

    private float[] generateStats() {
        float[] stats = new float[5];
        for (int i = 0; i < stats.length; i++) {
            stats[i] = random.nextFloat() * 100;
        }
        return stats;
    }

    public float getHealth() {
        return this.health;
    }

    public float getAttack() {
        return this.attack;
    }

    public float getDefense() {
        return this.defense;
    }

    public float getHunger() {
        return this.hunger;
    }

    public float getThirst() {
        return this.thirst;
    }

    public String getType() {
        return this.antType;
    }

    public void setHealth(double multiplayer) {
        this.health *= multiplayer;
    }

    public void setAttack(double multiplayer) {
        this.attack *= multiplayer;
    }

    public void setDefense(double multiplayer) {
        this.defense *= multiplayer;
    }

    public void setHunger(int multiplayer) {
        this.hunger += multiplayer;
    }

    public void setThirst(int multiplayer) {
        this.thirst += multiplayer;
    }

    // abstract must go before void
    public abstract void update();
}
