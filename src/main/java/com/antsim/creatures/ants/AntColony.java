package com.antsim.creatures.ants;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class AntColony{
    private List<Ant> ants = new ArrayList<>();
    boolean isRunning = true;

    public void addAnt(Ant ant) {
        ants.add(ant);
    }

    public void simulate() {
        while (isRunning) {
            Iterator<Ant> iterator = ants.iterator();
            
            while (iterator.hasNext()) {
                Ant ant = iterator.next();
                ant.update();
                if (ant.getHealth() <= 0) {
                    iterator.remove();
                }
            }

            // Пауза для имитации игрового цикла
            try { Thread.sleep(1000); } 
            catch (InterruptedException e) {isRunning = false;}
        }
    }

    public void updateStats(Ant ant) {
        if (ant.getHunger() < 30) {
            ant.setAttack(0.8);
            ant.setDefense(0.8);
        } 
        if (ant.getHunger() <= 0) {
            ant.setHealth(-5);
        }
    }
}