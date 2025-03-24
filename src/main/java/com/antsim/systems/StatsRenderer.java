package com.antsim.systems;

import java.util.stream.Collectors;
import org.fusesource.jansi.Ansi;
import com.antsim.world.*;
import com.antsim.creatures.Creature;


public class StatsRenderer {
    public static void drawStats(GameWorld world) {
        Ansi stats = Ansi.ansi()
            .cursor(40, 0) // Позиция под картой
            .fg(Ansi.Color.WHITE)
            .a("Тип      HP     Голод   Атака\n")
            .a("------------------------------\n");

        // Сбор данных
        /* 
        world.getCreatures().stream()
            .collect(Collectors.groupingBy(Creature::getType))
            .forEach((type, ants) -> {
                int avgHp = (int) ants.stream().mapToInt(Creature::getHealth).average().orElse(0);
                int avgHunger = (int) ants.stream().mapToInt(Creature::getHunger).average().orElse(0);
                stats.a(String.format("%-8s %-6d %-8d %-6d\n", 
                    type, avgHp, avgHunger, ants.get(0).getAttack()));
            });
        */

        System.out.println(stats);
    }
}