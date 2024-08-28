package com.booleanuk.model.item.potion;

import com.booleanuk.model.item.Item;

public abstract class Potion extends Item {

    public Potion(String name, int requiredLvl) {
        super(name, requiredLvl);
    }
}
