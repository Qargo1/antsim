package com.antsim.world.worldItems;

import java.util.Random;
import lombok.Getter;


public class Food {
    protected @Getter int capacity;

    public Food() {
        int randInt = new Random().nextInt(70);
        this.capacity = randInt;
    }
}