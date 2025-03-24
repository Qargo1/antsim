package com.antsim;

import com.antsim.systems.GameLoop;
import com.antsim.world.*;


public class Main {
    public static void main(String[] args) {
        SplitMap splitMap = new SplitMap(20, 40, 60, 100); // Пример значений
        WorldRenderer renderer = new WorldRenderer(splitMap);
        WorldMap map = new WorldMap(100, 20);
        GameWorld gameWorld = new GameWorld();

        // Создаем игровой цикл
        GameLoop gameLoop = new GameLoop(map, renderer, gameWorld, splitMap);

        // Запуск игры
        gameLoop.start();
    }
}