package com.antsim.world;


public class SplitMap {
    private int middleHeight; // Лес
    private int lowerHeight; // Муравейник
    private int upperHeight; // Вражеский муравейник, спавнится через 4 игровые минуты
    private int PLAYER_ANTHILL_Y1;
    private int PLAYER_ANTHILL_Y2;
    private int height;

    public SplitMap(
        int middleHeight, 
        int lowerHeight, 
        int upperHeight,
        int height
        ) {
        this.middleHeight = middleHeight;
        this.lowerHeight = lowerHeight;
        this.upperHeight = upperHeight;
        this.height = height;
        int PLAYER_ANTHILL_Y1 = height * 2/3;
        int PLAYER_ANTHILL_Y2 = height;
    }

    public int[] getZones() {
        return new int[] {upperHeight, middleHeight, lowerHeight};
    }
}
