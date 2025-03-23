package com.antsim.creatures;
import java.awt.Point;


public abstract class Creature {
    protected float health;
    protected float attack;
    protected float defense;
    protected Point position = new Point();

    public abstract void update();

    public void moveTo(Point target, int speed) {
        double angle = Math.atan2(target.y - position.y, target.x - position.x);
        position.x += speed * Math.cos(angle);
        position.y += speed * Math.sin(angle);
    }
}