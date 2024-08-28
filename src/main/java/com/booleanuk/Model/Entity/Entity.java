package com.booleanuk.Model.Entity;

import com.booleanuk.Model.Element.Element;
import com.booleanuk.Model.Item.Item;
import com.booleanuk.Model.Item.Shield;
import com.booleanuk.Model.Item.Weapon.Weapon;
import com.booleanuk.Model.Item.potion.Potion;
import com.booleanuk.Model.Spell.Spell;

import java.util.ArrayList;
import java.util.Random;

public abstract class Entity {
    private String name;
    private int HP;
    private Shield shield;
    private int mana;
    private Element element;
    private Inventory inventory;
    private int level;
    private int experience;
    private Weapon weapon;
    private ArrayList<Spell> spells;
    private String id;

    public Entity(String name, int baseHP, int baseMana) {
        this.name = name;
        this.HP = baseHP;
        this.mana = baseMana;
        this.inventory = new Inventory(10);
        this.level = 1;
        this.experience = 0;
        this.shield = null;
    }

    public Entity(String name, int baseHP, int baseMana, int level) {
        this.name = name;
        this.HP = baseHP;
        this.mana = baseMana;
        this.inventory = new Inventory(10);
        this.level = level;
        this.experience = 0;
        this.shield = null;
    }


    public int decreaseHP(int amount) {
        this.HP -= amount;
        return amount;
    }

    protected int decreaseMana(int amount){
        this.mana -= amount;

        return amount;
    }

    public int getAttacked(Weapon enemyWeapon) {
        if (this.shield != null) {
            return decreaseHP(shieldChecker(enemyWeapon));
        } else {
            return decreaseHP(enemyWeapon.getDamage());
        }
    }

    private int shieldChecker(Weapon enemyWeapon) {
        Random r = new Random();
        float blockChance = r.nextFloat(0, 100) / 100;
        if (blockChance <= shield.getBlockChance()) {
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

    public void setHP(int HP) {
        this.HP = HP;
    }

    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        if (inventory.contains(shield.getId())) {
            this.shield = shield;
        }
    }

    public float getMana() {
        return mana;
    }

    public void setMana(int mana) {
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
        if (inventory.contains(weapon.getId())) {
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

    public boolean useHealthPotion() {
        return this.inventory.removeHealthPotion();
    }

}
