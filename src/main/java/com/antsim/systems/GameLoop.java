package com.antsim.systems;

import java.awt.Point;
import java.util.Random;

import com.antsim.creatures.ants.QueenAntRival;
import com.antsim.creatures.ants.QueenAnt;
import com.antsim.creatures.enemies.*;
import com.antsim.world.*;
import lombok.Getter;
import lombok.Setter;


public class GameLoop {
    private WorldMap map;
    private WorldRenderer renderer;
    private GameWorld gameWorld;
    private long lastStatsUpdate = 0;
    private @Getter @Setter boolean isRunning;
    private long lastSpawnTime;
    private QueenAnt queen;
    private QueenAntRival queenAntRival;
    private Random random = new Random();
    private SplitMap splitMap;

    public GameLoop(WorldMap map, WorldRenderer renderer, GameWorld gameWorld, SplitMap splitMap) {
        this.splitMap = splitMap;
        this.map = map;
        this.renderer = renderer;
        this.gameWorld = gameWorld;
        this.isRunning = true;
        this.lastSpawnTime = System.currentTimeMillis();
    }

    public void start() {
        spawnQueenAnt();

        if (System.currentTimeMillis() >= 300_00) {
            spawnAntQueenRival();
        }

        while (isRunning) {
            clearConsole();
            update();
            renderer.drawMap(map, gameWorld);
            if (System.currentTimeMillis() - lastStatsUpdate > 2000) {
                StatsRenderer.drawStats(gameWorld);
                lastStatsUpdate = System.currentTimeMillis();
            }
            checkQueenHealth();
            sleep(1000);
        }
    }

    private void update() {
        gameWorld.update();
        spawnEnemies();
    }

    private void spawnEnemies() {
        if (System.currentTimeMillis() - lastSpawnTime >= 60000) {
            Point spawnPoint = new Point(
                random.nextInt(map.getWidth()),
                random.nextInt(map.getHeight())
            );
            EnemyType type = EnemyType.getRandomType(); // Логика выбора на основе шансов
            Enemy enemy = switch(type) {
                case SPIDER -> new Spider(spawnPoint); 
                case WASP -> new Wasp();
                case BEETLE -> new Beetle(); 
                case RHINOBEETLE -> new RhinoBeetle(); 
                case ANTLION -> new Antlion(); 
                // ...
            };
            gameWorld.addCreature(enemy);
            lastSpawnTime = System.currentTimeMillis();
        }
    }

    private void spawnQueenAnt() {
        Point spawnPoint = new Point(map.getWidth() / 2, map.getHeight() / 2);
        queen = new QueenAnt(spawnPoint, gameWorld);
        gameWorld.addCreature(queen);
    }

    private void spawnAntQueenRival() {
        // Изменить
        Point spawnPoint = new Point(map.getWidth() / 2, map.getHeight() / 2);
        queenAntRival = new QueenAntRival(spawnPoint, gameWorld);
        gameWorld.addCreature(queen);
    }

    private void checkQueenHealth() {
        if (queen != null && queen.getHealth() <= 0) {
            stop();
        }
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            isRunning = false;
        }
    }

    public void stop() {
        isRunning = false;
        System.out.println("Game Over! The queen has died.");
    }
}