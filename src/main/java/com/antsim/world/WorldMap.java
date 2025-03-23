package com.antsim.world;
import java.util.Random;


public class WorldMap {
    private TileType[][] tiles;
    private int width;
    private int height;
    private Random random = new Random();

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new TileType[width][height];
        generateInitialAntMap();
        generateInitialMap(); // Теперь оба метода работают
    }

    private void generateInitialAntMap() {
        // Центр муравейника
        int centerX = width / 2;
        int centerY = height / 2;
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // 3x3 область вокруг центра - вход
                if (Math.abs(x - centerX) <= 1 && Math.abs(y - centerY) <= 1) {
                    tiles[x][y] = TileType.GROUND;
                } else {
                    tiles[x][y] = TileType.WALL;
                }
            }
        }
    }

    private void generateInitialMap() {
        // Заполняем периметр травой для теста
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (tiles[x][y] == null) { // Если не муравейник
                    tiles[x][y] = TileType.GROUND;
                }
            }
        }
    }

    // Исправленный метод
    public TileType getTile(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return TileType.WALL; // Границы карты
        }
        return tiles[x][y];
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}