package com.booleanuk.Model.Spell;

import com.booleanuk.Model.Attack.Attack;
import com.booleanuk.Model.Element.Element;

import java.util.Random;

public abstract class Spell {
    private String name;
    private Element element;
    private String typeOfSpell;
    private int manaCost;
    private int dmg;

    public Spell(String name, Element element, String typeOfSpell, int manaCost, int dmg) {
        this.name = name;
        this.element = element;
        this.typeOfSpell = typeOfSpell;
        this.manaCost = manaCost;
        this.dmg = dmg;
    }

    public int getDamage() {
        return this.dmg;
    }

    public int getManaCost() {
        return this.manaCost;
    }
}
