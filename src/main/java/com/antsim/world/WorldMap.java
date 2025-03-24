package com.antsim.world;

import java.util.Random;
import lombok.Getter;
import lombok.Setter;


public class WorldMap {
    private @Getter @Setter TileType[][] tiles;
    private @Getter @Setter int width;
    private @Getter @Setter int height;
    private int[] zones = new int[3]; // [0] верх, [1] середина, [2] низ
    private Random random = new Random();

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new TileType[width][height];
        generateInitialMap();
        this.zones[0] = height/3;   // Вражеский муравейник
        this.zones[1] = height*2/3; // Лес
        this.zones[2] = height;     // Игровой муравейник
    }

    private void generateInitialMap() {
        // Размеры муравейника (40% от карты)
        int anthillWidth = (int) (width * 0.4);
        int anthillHeight = (int) (height * 0.4);

        // Центр муравейника
        int centerX = width / 2;
        int centerY = height / 2;

        // Границы муравейника
        int anthillStartX = centerX - anthillWidth / 2;
        int anthillStartY = centerY - anthillHeight / 2;
        int anthillEndX = anthillStartX + anthillWidth;
        int anthillEndY = anthillStartY + anthillHeight;

        // Заполняем карту
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Если внутри муравейника
                if (x >= anthillStartX && x < anthillEndX && 
                    y >= anthillStartY && y < anthillEndY) {
                    tiles[x][y] = TileType.WALL; // Стены муравейника
                } else {
                    tiles[x][y] = TileType.GROUND; // Трава снаружи
                }
            }
        }

        // Квадрат для спавна матки (5x5 в центре муравейника)
        int spawnSize = 5;
        int spawnStartX = centerX - spawnSize / 2;
        int spawnStartY = centerY - spawnSize / 2;

        for (int x = spawnStartX; x < spawnStartX + spawnSize; x++) {
            for (int y = spawnStartY; y < spawnStartY + spawnSize; y++) {
                tiles[x][y] = TileType.GROUND; // Пустое место для матки
            }
        }
    }

    public boolean isDiggable(int x, int y) {
        return tiles[x][y] == TileType.WALL;
    }

    public void digTunnel(int x, int y) {
        if (isDiggable(x, y)) {
            tiles[x][y] = TileType.TUNNEL;
        }

        /*
        if (this.areTunnelsParallel(t1, t2)) {
            this.collapse();
        } */
    }

    public void getWallsAround() {
        // Найдем угол (с двух сторон стены)
        // Пройдем в одну сторону n шагов - уперлись в угол - запомнили
        // Повернули идем дальше по углу - уперлись в угол - запомнили
        // Сделали еще раз, запомнили - мы в коробке. Остаемся здесь некоторое время запомнив общую площадь.
        // Начнем рандомное движение в цели найти другую каробку, не равную этой по площади (нашли меньше остались ненадолго, если площадь больше ищем дальше)
        // И все это в пределах центральных 80% самого муравейника
    }

    public void exitPosition() {
        // Найти все границы карты, где нету стены.
    }

    public TileType getTile(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return TileType.WALL; // Границы карты
        }
        return tiles[x][y];
    }
}