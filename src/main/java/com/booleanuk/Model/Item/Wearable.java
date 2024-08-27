package com.booleanuk.Model.Item;

public abstract class Wearable extends Item {
    private float durability;

    public Wearable(String name, int requiredLvl) {
        super(name, requiredLvl);
        this.durability = 100;
    }

    public void decreaseWear() {
        this.durability -= 1.1f;
    }

    public void repairWear() {
        this.durability = 100;
    }
}
