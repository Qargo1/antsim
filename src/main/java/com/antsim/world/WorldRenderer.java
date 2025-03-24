package com.antsim.world;

import com.antsim.creatures.Creature;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import com.antsim.creatures.ants.*;
import com.antsim.creatures.enemies.*;
import com.antsim.systems.GameEngine;


public class WorldRenderer {
    static {
        AnsiConsole.systemInstall(); // Инициализация Jansi
    }

    private int[] zones;

    public WorldRenderer(WorldMap map) {
        this.zones = map.getZones();
    }

    public void drawMap(WorldMap map, GameEngine engine) {
        Ansi buffer = Ansi.ansi();

        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                Creature creature = getCreatureAt(engine, x, y);

                if (creature != null) {
                    buffer.a(getCreatureSymbol(creature))
                        .fg(getCreatureColor(creature))
                        .fgDefault();
                } else {
                    TileType tile = map.getTile(x, y);
                    buffer.a(getTileSymbol(tile, y))
                        .fg(getTileColor(tile))
                        .fgDefault(); // сброс цвета
                }
            }
            buffer.newline();
        }

        System.out.println(buffer);
    }

    private Creature getCreatureAt(GameEngine engine, int x, int y) {
        for (Creature creature : engine.getCreatures()) {
            if (creature.getPosition().x == x && creature.getPosition().y == y) {
                return creature;
            }
        }
        return null;
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

    private String getTileSymbol(TileType tile, int y) {
        if (y < zones[0]) return "☠";  // Вражеская зона
        if (y < zones[1]) return "♣";  // Лес
        return switch(tile) {
            case WALL -> "▓▓";
            case TUNNEL -> "  ";
            case GROUND -> "░░";
            case WATER -> "~~";
            case FOOD -> "🍎";
            case BORDER -> "▧";
            case EXIT -> " ";
        };
    }

    private Ansi.Color getCreatureColor(Creature creature) {
        if (creature instanceof QueenAnt) {
            return Ansi.Color.MAGENTA; // Матка
        } else if (creature instanceof Spider) {
            return Ansi.Color.RED; // Враг
        }
        return Ansi.Color.WHITE; // Другие существа
    }

    private String getCreatureSymbol(Creature creature) {
        if (creature instanceof QueenAnt) {
            return "QA"; // Матка
        } else if (creature instanceof BuilderAnt) {
            return "BA"; // Враг
        } else if (creature instanceof NurseAnt) {
            return "NA"; // Враг
        } else if (creature instanceof SoldierAnt) {
            return "SA"; // Враг
        } else if (creature instanceof WorkerAnt) {
            return "WA"; // Враг
        } else if (creature instanceof Spider) {
            return "SE"; // Враг
        } else if (creature instanceof Antlion) {
            return "AE";
        } else if (creature instanceof Beetle) {
            return "BE";
        } else if (creature instanceof RhinoBeetle) {
            return "RE";
        } else if (creature instanceof Wasp) {
            return "WE";
        } else if (creature instanceof Egg) {
            return "EG"; // Враг
        }
        return "? "; // Другие существа
    }
}