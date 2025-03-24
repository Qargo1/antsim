package com.antsim.creatures.ants;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.Getter;


public class AntManager {
    private @Getter List<Ant> ants = new ArrayList<>();
    private @Getter List<Egg> eggs = new ArrayList<>();
    private boolean isRunning = true;

    public AntManager() {
        
    }

    // Фабричный метод для создания муравьев
    public Ant createAnt(String type, Point position) {
        Ant ant = switch (type.toLowerCase()) {
            case "worker" -> new WorkerAnt(position);
            case "queen" -> new QueenAnt(position);
            case "soldier" -> new SoldierAnt(position);
            case "nurse" -> new NurseAnt(position);
            case "builder" -> new BuilderAnt(position);
            default -> throw new IllegalArgumentException("Неизвестный тип муравья: " + type);
        };
        ants.add(ant);
        return ant;
    }

    // Управление колонией
    public void addAnt(Ant ant) {
        ants.add(ant);
    }

    public void addEgg(Egg egg) {
        eggs.add(egg);
    }

    public void simulate() {
        while (isRunning) {
            updateColony();
            sleep(1000);
        }
    }

    private void updateColony() {
        Iterator<Ant> iterator = ants.iterator();
        while (iterator.hasNext()) {
            Ant ant = iterator.next();
            ant.update();
            updateStats(ant);
            if (ant.getHealth() <= 0) {
                iterator.remove();
            }
        }
    }

    private void updateStats(Ant ant) {
        if (ant.getHunger() < 30) {
            ant.setAttack(ant.getAttack() * 0.8f);
            ant.setDefense(ant.getDefense() * 0.8f);
        } 
        if (ant.getHunger() <= 0) {
            ant.setHealth(ant.getHealth() - 5);
        }
    }

    private void sleep(long millis) {
        try { 
            Thread.sleep(millis); 
        } catch (InterruptedException e) {
            isRunning = false;
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }

    public int getColonySize() {
        return ants.size() + eggs.size();
    }
}