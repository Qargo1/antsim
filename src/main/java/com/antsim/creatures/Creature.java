package com.antsim.creatures;
import java.awt.Point;
import java.util.Random;

import javax.swing.text.Position;


public abstract class Creature {
    protected float health;
    protected float attack;
    protected float defense;
    protected Point position = new Point();
    protected Random random = new Random();

    // Базовое обновление (движение + другие действия)
    public abstract void update();

    // Движение к цели
    public void moveTo(Point target, int speed) {
        double angle = Math.atan2(target.y - position.y, target.x - position.x);
        position.x += speed * Math.cos(angle);
        position.y += speed * Math.sin(angle);
    }

    // Случайное движение
    public void wander(int speed) {
        // Случайное изменение направления каждые несколько шагов
        if (random.nextInt(10) == 0) { // 10% шанс изменить направление
            Point randomTarget = new Point(
                position.x + random.nextInt(21) - 10, // -10..10
                position.y + random.nextInt(21) - 10
            );
            moveTo(randomTarget, speed);
        } else {
            // Продолжаем движение в текущем направлении
            moveTo(new Point(position.x + 1, position.y + 1), speed);
        }
    }

    public float getHealth() {
        return this.health;
    }

    public Point getPosition() {
        return this.position;
    }
}