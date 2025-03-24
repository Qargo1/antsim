package com.antsim;

import com.antsim.systems.GameEngine;
import com.antsim.world.*;


public class Main {
    public static void main(String[] args) {
        WorldMap map = new WorldMap(30, 30);
        WorldRenderer renderer = new WorldRenderer(map);

        // Создаем игровой цикл
        GameEngine gameLoop = new GameEngine(map, renderer);

        // Запуск игры
        gameLoop.start();
    }
}