/*
package com.antsim.systems;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


public class LanternaRenderer {
    private Terminal terminal;
    private TextGraphics textGraphics;

    public LanternaRenderer() throws IOException {
        terminal = new DefaultTerminalFactory().createTerminal();
        textGraphics = terminal.newTextGraphics();
        terminal.enterPrivateMode();
    }

    public void drawMap(WorldMap map, GameWorld gameWorld) throws IOException {
        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                Creature creature = getCreatureAt(gameWorld, x, y);
                if (creature != null) {
                    textGraphics.setForegroundColor(getCreatureColor(creature));
                    textGraphics.putString(x, y, getCreatureSymbol(creature));
                } else {
                    TileType tile = map.getTile(x, y);
                    textGraphics.setForegroundColor(getTileColor(tile));
                    textGraphics.putString(x, y, getTileSymbol(tile));
                }
            }
        }
        terminal.flush();
    }

    public void close() throws IOException {
        terminal.exitPrivateMode();
    }
}
*/