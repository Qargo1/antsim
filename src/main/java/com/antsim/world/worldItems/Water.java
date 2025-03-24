package com.antsim.world.worldItems;

import java.util.Random;

public class Water {
    protected int capacity;

        public Water() {
        int randInt = new Random().nextInt(70);
        this.capacity = randInt;
    }
}
