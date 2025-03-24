package com.antsim.world.worldItems;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;


public class Stuff {
    private @Setter @Getter ArrayList<String> type = new ArrayList<>();

    public Stuff() {
        this.type.add("rock");
    }
}
