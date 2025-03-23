package com.antsim.world;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class WorldRenderer {
    static {
        AnsiConsole.systemInstall(); // Инициализация Jansi
    }

    public void drawMap(WorldMap map) {
        Ansi buffer = Ansi.ansi();
        
        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                TileType tile = map.getTile(x, y);
                buffer.a(getTileSymbol(tile)).fg(getTileColor(tile));
            }
            buffer.newline();
        }
        
        System.out.println(buffer);
    }

    private Ansi.Color getTileColor(TileType tile) {
        return switch(tile) {
            case WALL -> Ansi.Color.YELLOW;
            case TUNNEL -> Ansi.Color.BLACK;
            case GROUND -> Ansi.Color.GREEN;
            case WATER -> Ansi.Color.BLUE;
            case FOOD -> Ansi.Color.RED;
            default -> Ansi.Color.WHITE;
        };
    }

    private String getTileSymbol(TileType tile) {
        return switch(tile) {
            case WALL -> "▓▓";
            case TUNNEL -> "  ";
            case GROUND -> "░░";
            case WATER -> "~~";
            case FOOD -> "🍎";
            default -> "??";
        };
    }
}