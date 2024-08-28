package com.booleanuk.model.entity.enemies;

import com.booleanuk.model.element.Element;

public class Goblin extends Enemy {

    public Goblin(Element element, int level) {
        super("Goblin", 32, 68, element, level);
    }
}
