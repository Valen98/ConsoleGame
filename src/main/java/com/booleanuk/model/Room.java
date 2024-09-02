package com.booleanuk.model;

import com.booleanuk.model.entity.Entity;
import com.booleanuk.model.item.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private String id;
    private int lvl;
    private int nrOfEnemies;
    private int doors;
    private boolean isPlayerInside = false;
    private ArrayList<Entity> enemyList;
    private ArrayList<Item> droppedItems;

    public Room(String id, int lvl, int nrOfEnemies, int doors){
        this.id = id;
        this.enemyList = new ArrayList<>();
        this.droppedItems = new ArrayList<>();
        this.lvl = lvl;
        this.nrOfEnemies = nrOfEnemies;
        this.doors = doors;
    }

    public void addItems(Entity entity){
        this.droppedItems.addAll(entity.getInventory().getItems());
    }

    public void addEnemy(HashMap<String, Entity> enemies){
        for(String id : enemies.keySet()){
            this.enemyList.add(enemies.get(id));
        }
    }

    public void goIntoRoom() {
        this.isPlayerInside = true;
    }

    public void goOutOfRoom() {
        this.isPlayerInside = false;
    }

    public boolean getIsPlayerInside() {
        return this.isPlayerInside;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Entity> getEnemyList() {
        return this.enemyList;
    }

    public int getNrOfEnemies() {
        return this.nrOfEnemies;
    }

    public void generateEnemies() {

        for (int i = 0; i < this.nrOfEnemies; i++) {

        }
    }

    public int getDoors() {
        return doors;
    }
}


