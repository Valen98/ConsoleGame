package com.booleanuk.Model.Entity;

import com.booleanuk.Model.Element.Element;
import com.booleanuk.Model.Item.Item;
import com.booleanuk.Model.Item.Shield;
import com.booleanuk.Model.Item.Weapon.Weapon;
import com.booleanuk.Model.Spell.Spell;

import java.util.ArrayList;
import java.util.Random;

public abstract class Entity {
    private String name;
    private float HP;
    private Shield shield;
    private float mana;
    private Element element;
    private Inventory inventory;
    private int level;
    private int experience;
    private Weapon weapon;
    private ArrayList<Spell> spells;
    private String id;

    public Entity(String name, float baseHP, float baseMana) {
        this.name = name;
        this.HP = baseHP;
        this.mana = baseMana;
        this.inventory = new Inventory(10);
        this.level = 1;
        this.experience = 0;
        this.shield = null;
    }

    public Entity(String name, float baseHP, float baseMana, int level) {
        this.name = name;
        this.HP = baseHP;
        this.mana = baseMana;
        this.inventory = new Inventory(10);
        this.level = level;
        this.experience = 0;
        this.shield = null;
    }



    public void decreaseHP(float amount) {
        this.HP -= amount;
    }

    public void getAttacked(Weapon enemyWeapon) {
        if (shield != null) {
            decreaseHP(shieldChecker(enemyWeapon));
        } else {
            decreaseHP(enemyWeapon.getDamage());
        }
    }

    private float shieldChecker(Weapon enemyWeapon) {
        Random r = new Random();
        float blockChange = r.nextFloat(0, 100) / 100;
        if (blockChange <= shield.getBlockChance()) {
            System.out.println("Attack blocked");
            return 0;
        } else {
            return enemyWeapon.getDamage();
        }
    }

    public void getAttacked(Spell enemySpell) {
        if (shield != null) {
            Random r = new Random();
            float blockChange = r.nextFloat(0, 100) / 100;
            if (blockChange <= shield.getBlockChance()) {
                System.out.println("Attack blocked");
            } else {
                decreaseHP(enemySpell.getDamage());
            }
        } else {
            decreaseHP(enemySpell.getDamage());
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHP() {
        return HP;
    }

    public void setHP(float HP) {
        this.HP = HP;
    }

    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public float getMana() {
        return mana;
    }

    public void setMana(float mana) {
        this.mana = mana;
    }

    public Element getElement() {
        return element;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addItemToInventory(Item item) {
        this.inventory.addItemToInventory(item);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        if(inventory.contains(weapon.getId())) {
            System.out.println("Set weapong " + weapon);
            this.weapon = weapon;
        }
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
