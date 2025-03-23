package com.antsim.world;
import java.util.List;
import com.antsim.creatures.Creature;
import java.util.ArrayList;


public class GameWorld {
    private List<Creature> creatures = new ArrayList<>();

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public void update() {
        for (Creature creature : creatures) {
            creature.update();
        }
    }
}