package com.booleanuk.Model.Entity.Enemies;

import com.booleanuk.Model.Element.Element;
import com.booleanuk.Model.Entity.Enemy;

public class Goblin extends Enemy {

    public Goblin(Element element, int level) {
        super("Goblin", 32, 68, element, level);
    }
}
