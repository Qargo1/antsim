package com.antsim.world;

import com.antsim.creatures.Creature;
import com.antsim.creatures.ants.Egg;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


public class GameWorld {
    private @Getter @Setter List<Creature> creatures = new ArrayList<>();
    private @Getter @Setter List<Egg> eggs = new ArrayList<>();

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public void addEgg(Egg egg) {
        eggs.add(egg);
    }

    public void update() {
        eggs.forEach(Egg::update);
        eggs.removeIf(egg -> egg.getHatchTimer() <= 0);
        
        creatures.forEach(Creature::update);
        creatures.removeIf(creature -> creature.getHealth() <= 0);
    }
}