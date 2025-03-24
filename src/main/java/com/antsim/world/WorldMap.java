package com.antsim.world;

import java.util.Random;
import lombok.Getter;
import lombok.Setter;


public class WorldMap {
    private @Getter @Setter TileType[][] tiles;
    private @Getter @Setter int width;
    private @Getter @Setter int height;
    private Random random = new Random();

    // Зонирование карты
    private int[] zones; // [0] верх (вражеский муравейник), [1] середина (лес), [2] низ (игровой муравейник)
    private @Getter int playerAnthillY1;
    private @Getter int playerAnthillY2;

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new TileType[width][height];

        // Инициализация зон
        this.zones = new int[] {
            height/3,    // Вражеский муравейник
            height*2/3,  // Лес
            height       // Игровой муравейник
        };

        this.playerAnthillY1 = height * 2/3;
        this.playerAnthillY2 = height - 1;

        generateInitialMap();
    }

    public int[] getZones() {
        return this.zones;
    }

    private void generateInitialMap() {
        // Центр муравейника
        int centerX = (width -1) / 2;
        int centerY = height / 2;

        // Границы муравейника
        int anthillStartX = centerX / 2;
        int anthillStartY = zones[1]; // Начинается от границы леса
        int anthillEndX = Math.min(anthillStartX, width - 1); // защита от выхода
        int anthillEndY = zones[2];   // До конца карты

        for (int y = anthillStartY; y < anthillEndY; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = TileType.WALL; // Стены муравейника
            }
        }

        // Заполняем карту
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Если внутри муравейника
                if (x >= anthillStartX && x < anthillEndX && 
                    y >= anthillStartY && y < anthillEndY) {
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
            return TileType.BORDER;
        }
        return tiles[x][y];
    }
}