package com.antsim;

import com.antsim.systems.GameLoop;
import com.antsim.world.GameWorld;
import com.antsim.world.WorldMap;
import com.antsim.world.WorldRenderer;

public class Main {
    public static void main(String[] args) {
        WorldMap map = new WorldMap(100, 20);
        WorldRenderer renderer = new WorldRenderer();
        GameWorld gameWorld = new GameWorld();

        // Создаем игровой цикл
        GameLoop gameLoop = new GameLoop(map, renderer, gameWorld);

        // Запуск игры
        gameLoop.start();
    }
}