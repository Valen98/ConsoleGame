package com.booleanuk.Model.Spell;

import com.booleanuk.Model.Attack.Attack;
import com.booleanuk.Model.Element.Element;

import java.util.Random;

public abstract class Spell {
    String name;
    Element element;
    String typeOfSpell;
    float manaCost;
    int dmg;

    public Spell(String name, Element element, String typeOfSpell, float manaCost, int dmg) {
        this.name = name;
        this.element = element;
        this.typeOfSpell = typeOfSpell;
        this.manaCost = manaCost;
        this.dmg = dmg;
    }

    public float getDamage() {
        return this.dmg;
    }
}
