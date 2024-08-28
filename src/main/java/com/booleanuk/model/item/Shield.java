package com.booleanuk.model.item;

public abstract class Shield extends Wearable {

    private float blockChance;

    public Shield(String name, int requiredLvl, float blockChance) {
        super(name, requiredLvl);
        System.out.println(requiredLvl);
        this.blockChance = requiredLvl * blockChance;
    }

    public void blockAttack() {
        this.decreaseWear();
    }

    public float getBlockChance() {
        return this.blockChance;
    }

    public void setBlockChance(float blockChance) {
        this.blockChance = blockChance;
    }

}
