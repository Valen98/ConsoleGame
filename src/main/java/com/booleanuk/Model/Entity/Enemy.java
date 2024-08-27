package com.booleanuk.Model.Entity;

import com.booleanuk.Model.Element.Element;

public abstract class Enemy extends Entity{

    public Enemy(String name, float baseHP, float baseMana, Element element, int level) {
        super(name, baseHP, baseMana, level);
        this.setElement(element);
    }

}
