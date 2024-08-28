package com.booleanuk.model.item;

public abstract class Item {
    private String id;
    private String name;
    private int requiredLvl;

    public Item(String name, int requiredLvl) {
        this.name = name;
        this.requiredLvl = requiredLvl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
