package com.booleanuk.Model.Spell;

import com.booleanuk.Model.Attack.Attack;
import com.booleanuk.Model.Element.Element;

public abstract class Spell extends Attack {
    String name;
    Element element;
    String typeOfSpell;
    float manaCost;

    public Spell(String name, Element element, String typeOfSpell, float manaCost) {
        this.name = name;
        this.element = element;
        this.typeOfSpell = typeOfSpell;
        this.manaCost = manaCost;
    }
}
