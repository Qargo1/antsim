package com.antsim;

import com.antsim.world.WorldMap;
import com.antsim.world.WorldRenderer;

public class Main {
    public static void main(String[] args) {
        WorldMap map = new WorldMap(20, 20);
        WorldRenderer renderer = new WorldRenderer();
        
        // Прорыть тестовый туннель
        /*
        map.digTunnel(10, 10);
        map.digTunnel(10, 11);
        */
        
        renderer.drawMap(map);
    }
}