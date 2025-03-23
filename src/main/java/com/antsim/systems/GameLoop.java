package com.antsim.systems;

import com.antsim.creatures.ants.QueenAnt;
import com.antsim.creatures.enemies.Spider;
import com.antsim.world.WorldMap;
import com.antsim.world.WorldRenderer;
import com.antsim.world.GameWorld;
import java.awt.Point;
import java.util.Random;


public class GameLoop {
    private Random random = new Random();
    private WorldMap map;
    private WorldRenderer renderer;
    private GameWorld gameWorld;
    private boolean isRunning;
    private long lastSpawnTime = System.currentTimeMillis();
    private QueenAnt queen; // Матка теперь поле класса

    public GameLoop(WorldMap map, WorldRenderer renderer, GameWorld gameWorld) {
        this.map = map;
        this.renderer = renderer;
        this.gameWorld = gameWorld;
        this.isRunning = true;
    }

    public void start() {
        // Спавн матки один раз при старте
        spawnQueenAnt();

        while (isRunning) {
            // Очистка консоли
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Обновление состояния игры
            update();

            // Отрисовка карты
            renderer.drawMap(map, gameWorld);

            // Пауза между кадрами
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Проверка здоровья матки
            if (queen.getHealth() <= 0) {
                this.stop();
            }
        }
    }

    private void spawnEnemy() {
        Point spawnPoint = new Point(
            random.nextInt(map.getWidth()), // Случайная позиция по X
            random.nextInt(map.getHeight()) // Случайная позиция по Y
        );
        Spider spider = new Spider(spawnPoint);
        gameWorld.addCreature(spider); // Добавляем врага в мир
    }

    private void spawnQueenAnt() {
        Point spawnPoint = new Point(map.getWidth() / 2, map.getHeight() / 2);
        queen = new QueenAnt(spawnPoint);
        gameWorld.addCreature(queen); // Добавляем матку в мир
    }

    private void update() {
        long currentTime = System.currentTimeMillis();

        // Спавн врага каждые 60 секунд
        if (currentTime - lastSpawnTime >= 60000) { // 60 секунд
            spawnEnemy();
            lastSpawnTime = currentTime;
        }

        // Обновляем всех существ
        gameWorld.update();
    }

    public void stop() {
        isRunning = false;
        System.out.println("Game Over! The queen has died.");
    }
}