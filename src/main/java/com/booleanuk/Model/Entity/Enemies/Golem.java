package com.booleanuk.Model.Entity.Enemies;

import com.booleanuk.Model.Element.Element;
import com.booleanuk.Model.Entity.Enemy;

public class Golem extends Enemy {

    public Golem(Element element, int level) {
        super("Golem", 180, 90, element, level);
    }

}
