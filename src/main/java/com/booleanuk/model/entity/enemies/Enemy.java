package com.booleanuk.model.entity.enemies;

import com.booleanuk.model.element.Element;
import com.booleanuk.model.entity.Entity;

public abstract class Enemy extends Entity {

    public Enemy(String name, int baseHP, int baseMana, Element element, int level) {
        super(name, baseHP, baseMana, level);
        this.setElement(element);
    }

}
