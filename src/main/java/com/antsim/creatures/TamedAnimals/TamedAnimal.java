package com.antsim.creatures.tamedAnimals;
import com.antsim.creatures.Creature;


public abstract class TamedAnimal extends Creature {
    protected float foodValue; // Количество пищи при убийстве
    protected float helpPower; // Бонус для колонии
}