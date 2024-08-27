package com.booleanuk.Model.Item;

public abstract class Shield extends Wearable{
    float blockChance;
    public Shield(String name, int requiredLvl) {
        super(name, requiredLvl);
    }

    public void blockAttack() {
        this.decreaseWear();
    }

    public float getBlockChance() {
        return this.blockChance;
    }
}
