package com.antsim.creatures.tamedAnimals;


public class Aphid extends TamedAnimal {
    public Aphid() {
        this.speed = 0; // очень медленная, атаки нет
        /*
        Генерирует сок - в котором с 50% шансом будет либо еда либо вода
        с рандомной capacity. Но только если находится внутри муравейника
        Причем должен работать и вражеский муравейник сверху
         */
    }

    @Override
    public void update() {

    }

}
