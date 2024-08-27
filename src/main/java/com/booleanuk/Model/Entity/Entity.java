package com.booleanuk.Model.Entity;

import com.booleanuk.Model.Entity.Element.Element;
import com.booleanuk.Model.Item.Item;
import com.booleanuk.Model.Item.Shield;
import com.booleanuk.Model.Item.Weapon.Weapon;

import java.util.ArrayList;

public abstract class Entity {
    String name;
    float HP;
    Element element;
    Inventory intentory;
    int level;
    int experience;
    Shield shield;
    Weapon weapon;

    public Entity(String name, float baseHP, Element element) {
        this.name = name;
        this.HP = baseHP;
        this.element = element;
        this.intentory = new Inventory(10);
        this.level = 1;
        this.experience = 0;

    }


    public void decreaseHP(float amount) {
        this.HP -= amount;
    }
}
