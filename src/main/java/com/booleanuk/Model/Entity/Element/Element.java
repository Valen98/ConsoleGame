package com.booleanuk.Model.Entity.Element;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Element {
    private HashMap<Element, Float> weakness;

    public Element(HashMap<Element, Float> weakness) {
        this.weakness = weakness;
    }


}
