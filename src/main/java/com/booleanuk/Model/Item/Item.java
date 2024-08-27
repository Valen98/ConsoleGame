package com.booleanuk.Model.Item;

public abstract class Item {
    String name;
    int requiredLvl;

    public Item(String name, int requiredLvl) {
        this.name = name;
        this.requiredLvl = requiredLvl;
    }
}
