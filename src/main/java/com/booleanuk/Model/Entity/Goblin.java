package com.booleanuk.Model.Entity;

import com.booleanuk.Model.Element.Element;

public class Goblin extends Enemy{

    public Goblin(Element element, int level) {
        super("Goblin", 32, 68, element, level);
    }
}
