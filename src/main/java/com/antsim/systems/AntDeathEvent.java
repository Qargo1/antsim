package com.antsim.systems;
import com.antsim.creatures.ants.Ant;

// Пример события:
public class AntDeathEvent {
    private final Ant ant;
    public AntDeathEvent(Ant ant) { this.ant = ant; }
}