package com.antsim.creatures.enemies;

import java.awt.Point;


public class Antlion extends Enemy{
    public Antlion() {
        super();
        this.speed = 1;
        this.attack = 40;

        /* 
        Может единожды за жизнь закапываться при hp < 50% становясь неуязвимым и восстанавливая хп
        Может утягивать ближайшего муравья с собой, данный муравей 
        становится неактивным и теряет 1% hp в секунду
         */

        this.health = 57;
        this.moveSpeed = 1.5f;
        this.isHostile = true;
        this.defense = 15;
    }

    public Antlion(Point position) {
        super(position);
        this.speed = 1;
        this.attack = 40;
        this.health = 57;
        this.moveSpeed = 1.5f;
        this.isHostile = true;
        this.position = position;
        this.defense = 15;
    }

    @Override
    public void update() {

    }
}
