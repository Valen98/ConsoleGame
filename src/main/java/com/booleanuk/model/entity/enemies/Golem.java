package com.booleanuk.model.entity.enemies;

import com.booleanuk.model.element.Element;

public class Golem extends Enemy {

    public Golem(Element element, int level) {
        super("Golem", 180, 90, element, level);
    }

}
