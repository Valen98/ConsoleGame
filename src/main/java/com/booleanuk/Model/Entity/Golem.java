package com.booleanuk.Model.Entity;

import com.booleanuk.Model.Element.Element;

public class Golem extends Enemy{

    public Golem(Element element, int level) {
        super("Golem", 180, 90, element, level);
    }

}
