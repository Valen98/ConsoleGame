package com.booleanuk.model.item.weapon;

public class Dagger extends Weapon{

    public Dagger(String name, int requiredLvl, int minDamage, int maxDamage, float criticalChance, float criticalMultiplier, float missChance) {
        super(name, requiredLvl, minDamage, maxDamage, criticalChance, criticalMultiplier, missChance);
    }
}
