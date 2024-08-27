package com.booleanuk.Model.Item.Weapon;

import com.booleanuk.Model.Item.Item;

public abstract class Weapon extends Item {
    private float minDamage;
    private float maxDamage;
    private float criticalChance;
    private float criticalMultiplier = 2;

    public Weapon(String name, int requiredLvl, float minDamage, float maxDamage, float criticalChance, float criticalMultiplier) {
        super(name, requiredLvl);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.criticalChance = criticalChance;
        this.criticalMultiplier = criticalMultiplier;

    }
}
