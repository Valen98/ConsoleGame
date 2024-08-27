package com.booleanuk.Model.Item.Weapon;

import com.booleanuk.Model.Attack.Attack;
import com.booleanuk.Model.Item.Wearable;

import java.util.Random;

public abstract class Weapon extends Wearable {
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


    public float getDamage() {
        Random r = new Random();

        return r.nextFloat(minDamage, maxDamage);
    }
}
