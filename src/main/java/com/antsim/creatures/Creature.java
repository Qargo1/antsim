package com.antsim.creatures;
import java.awt.Point;
import java.util.Random;

import com.antsim.creatures.ants.WorkerAnt;
import com.antsim.world.WorldMap;

import lombok.Getter;
import lombok.Setter;


public abstract class Creature {
    protected @Getter @Setter float health;
    protected @Getter @Setter float attack;
    protected @Getter @Setter float defense;
    protected @Getter @Setter float speed;
    protected @Getter String type;
    protected @Getter @Setter Point position = new Point();
    protected Random random = new Random();

    public Creature(Point position) {
        this.position = position;
    }

    public Creature() {
    }

    // Базовое обновление (движение + другие действия)
    public abstract void update();

    // Движение к цели
    public void moveTo(Point target, int speed, Creature ant, WorldMap map) {
        if (ant instanceof WorkerAnt && map.isDiggable(target.x, target.y)) {
            // Только рабочие могут капать стены
            // Изменить код ниже
            double angle = Math.atan2(target.y - position.y, target.x - position.x);
            position.x += speed * Math.cos(angle);
            position.y += speed * Math.sin(angle);
        } else {
            double angle = Math.atan2(target.y - position.y, target.x - position.x);
            position.x += speed * Math.cos(angle);
            position.y += speed * Math.sin(angle);
        }
    }

    // Движение к цели с игнорированием преград
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
}