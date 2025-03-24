package com.antsim.systems;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.fusesource.jansi.Ansi;

import com.antsim.creatures.Creature;
import com.antsim.creatures.ants.*;
import com.antsim.creatures.enemies.*;
import com.antsim.creatures.tamedAnimals.*;
import com.antsim.world.*;
import lombok.Getter;
import lombok.Setter;


public class GameEngine {
    private final WorldMap map;
    private final WorldRenderer renderer;
    private final AntManager antManager = new AntManager();
    private List<Creature> creatures = new ArrayList<>();

    private @Getter @Setter boolean isRunning;
    private long lastSpawnTime;
    private long lastStatsUpdate;
    private long lastRivalSpawnTime;
    private QueenAnt queen;
    private QueenAntRival queenAntRival;
    private Random random = new Random();

    public GameEngine(WorldMap map, WorldRenderer renderer) {
        this.isRunning = true;
        this.lastSpawnTime = System.currentTimeMillis();
        this.lastStatsUpdate = 0;
        this.map = map;
        this.renderer = renderer;
    }

    // Геттеры для доступа к состояниям
    public List<Creature> getCreatures() {
        return creatures;
    }

    public List<Ant> getAnts() {
        return creatures.stream()
            .filter(c -> c instanceof Ant)
            .map(c -> (Ant)c)
            .collect(Collectors.toList());
    }

    public void addCreature(Ant ant) {
        creatures.add(ant);
    }

    // Mane game cycle
    public void start() {
        spawnQueenAnt();

        if (System.currentTimeMillis() >= 300_000) {
            spawnAntQueenRival();
            lastRivalSpawnTime = System.currentTimeMillis();
        }

        while (isRunning) {
            clearConsole();
            updateGameState();
            renderer.drawMap(map, this);
            checkQueenHealth();

            if (System.currentTimeMillis() - lastStatsUpdate > 2000) {
                drawStats();
                lastStatsUpdate = System.currentTimeMillis();
            }

            sleep(1000);
        }
    }

    public void drawStats() {
        Ansi stats = Ansi.ansi()
            .cursor(40, 0) // Позиция под картой
            .fg(Ansi.Color.WHITE)
            .a("Тип      HP\n")
            .a("-----------\n");

        getCreatures().stream()
            .collect(Collectors.groupingBy(Creature::getType))
            .forEach((type, creatureList) -> {
                float avgHp = (float) creatureList.stream()
                    .mapToDouble(Creature::getHealth)
                    .average().
                    orElse(0);
                stats.a(String.format("%-8s %-6.1f\n", 
                    type, avgHp));
            });

        System.out.println(stats);
    }

    private void updateGameState() {
        updateEggs();
        updateCreatures();
        spawnEnemies();
    }

    private void updateEggs() {
        List<Egg> eggs = antManager.getEggs();
        eggs.forEach(Egg::update);
        eggs.removeIf(egg -> egg.getHatchTimer() <= 0);
    }

    private void updateCreatures() {
        creatures.forEach(Creature::update);
        creatures.removeIf(c -> c.getHealth() <= 0);
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
            creatures.add(enemy);
            lastSpawnTime = System.currentTimeMillis();
        }
    }

    private void spawnQueenAnt() {
        Point spawnPoint = new Point(map.getWidth() / 2, map.getHeight() / 4);
        queen = new QueenAnt(spawnPoint);
        creatures.add(queen);
    }

    private void spawnAntQueenRival() {
        // Изменить
        int spawnY = map.getZones()[1] + 1; // Ниже зоны леса (y >= height*2/3)
        Point spawnPoint = new Point(map.getWidth() / 2, spawnY);
        queenAntRival = new QueenAntRival(spawnPoint);
        creatures.add(queenAntRival);
    }

    private void checkQueenHealth() {
        if (queen != null && queen.getHealth() <= 0) {
            stop();
        }
    }

    private void clearConsole() {
        System.out.println(Ansi.ansi().eraseScreen().cursor(1, 1));
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