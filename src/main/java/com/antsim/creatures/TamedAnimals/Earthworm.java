package com.antsim.creatures.tamedAnimals;


public class Earthworm extends TamedAnimal {
    public Earthworm() {
        this.speed = 1; // очень медленная, атаки нет
        /*
        Может копать стены, двигается рандомно но в сторону от любого другого существа неподалеку
        При этом старается двигаться в сторону ближайших стен
        Данного червя можно использовать как еду, heath = foodcapacity
         */
    }

    @Override
    public void update() {

    }

}