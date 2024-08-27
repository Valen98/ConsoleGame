package com.booleanuk.Model.Entity;

import com.booleanuk.Model.Element.Element;
import com.booleanuk.Model.Item.Shield;
import com.booleanuk.Model.Item.Weapon.Weapon;
import com.booleanuk.Model.Spell.Spell;

import java.util.ArrayList;

public abstract class Entity {
    String name;
    float HP;
    Shield shield;
    float mana;
    Element element;
    Inventory intentory;
    int level;
    int experience;
    Weapon weapon;
    ArrayList<Spell> spells;

    public Entity(String name, float baseHP, float baseMana, Element element) {
        this.name = name;
        this.HP = baseHP;
        this.mana = baseMana;
        this.element = element;
        this.intentory = new Inventory(10);
        this.level = 1;
        this.experience = 0;

    }


    public void decreaseHP(float amount) {
        this.HP -= amount;
    }
}
