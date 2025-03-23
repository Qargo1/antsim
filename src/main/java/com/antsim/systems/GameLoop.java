package com.antsim.systems;

import java.awt.Point;
import java.util.Random;
import com.antsim.creatures.ants.QueenAnt;
import com.antsim.creatures.enemies.Spider;
import com.antsim.world.WorldMap;
import com.antsim.world.GameWorld;
import com.antsim.world.WorldRenderer;
import lombok.Getter;
import lombok.Setter;


public class GameLoop {
    private WorldMap map;
    private WorldRenderer renderer;
    private GameWorld gameWorld;
    private @Getter @Setter boolean isRunning;
    private long lastSpawnTime;
    private QueenAnt queen;
    private Random random = new Random();

    public GameLoop(WorldMap map, WorldRenderer renderer, GameWorld gameWorld) {
        this.map = map;
        this.renderer = renderer;
        this.gameWorld = gameWorld;
        this.isRunning = true;
        this.lastSpawnTime = System.currentTimeMillis();
    }

    public void start() {
        spawnQueenAnt();

        while (isRunning) {
            clearConsole();
            update();
            renderer.drawMap(map, gameWorld);
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
            Spider spider = new Spider(spawnPoint);
            gameWorld.addCreature(spider);
            lastSpawnTime = System.currentTimeMillis();
        }
    }

    private void spawnQueenAnt() {
        Point spawnPoint = new Point(map.getWidth() / 2, map.getHeight() / 2);
        queen = new QueenAnt(spawnPoint, gameWorld);
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