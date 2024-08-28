package com.booleanuk.Model.Item.Weapon;

import com.booleanuk.Model.Attack.Attack;
import com.booleanuk.Model.Item.Wearable;

import java.util.Random;

public abstract class Weapon extends Wearable {
    private int minDamage;
    private int maxDamage;
    private float criticalChance;
    private float criticalMultiplier = 2;
    private float missChance;
    private Attack attack;

    public Weapon(String name, int requiredLvl, int minDamage, int maxDamage, float criticalChance, float criticalMultiplier, float missChance) {
        super(name, requiredLvl);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.criticalChance = criticalChance;
        this.criticalMultiplier = criticalMultiplier;
        this.missChance = missChance;
    }


    public int getDamage() {
        Random r = new Random();

        return r.nextInt(minDamage, maxDamage);
    }
}
