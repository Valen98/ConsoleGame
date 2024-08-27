package com.booleanuk.Model.Item.Weapon;

import com.booleanuk.Model.Item.Item;
import com.booleanuk.Model.Attack.Attack;

public abstract class Weapon extends Item {
    private float minDamage;
    private float maxDamage;
    private float criticalChance;
    private float criticalMultiplier = 2;
    private float missChance;
    private Attack attack;

    public Weapon(String name, int requiredLvl, float minDamage, float maxDamage, float criticalChance, float criticalMultiplier, float missChance) {
        super(name, requiredLvl);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.criticalChance = criticalChance;
        this.criticalMultiplier = criticalMultiplier;
        this.missChance = missChance;
    }
}
