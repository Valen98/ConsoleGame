package com.booleanuk.Model.Entity;

import com.booleanuk.Model.Element.Element;

public abstract class Enemy extends Entity{

    public Enemy(String name, int baseHP, int baseMana, Element element, int level) {
        super(name, baseHP, baseMana, level);
        this.setElement(element);
    }

}
