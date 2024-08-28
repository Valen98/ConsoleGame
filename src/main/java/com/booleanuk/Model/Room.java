package com.booleanuk.Model;

import com.booleanuk.Model.Entity.Enemy;
import com.booleanuk.Model.Entity.Entity;
import com.booleanuk.Model.Item.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private int lvl;
    private int nrOfEnemies;
    private int doors;
    private ArrayList<Entity> enemyList;
    private ArrayList<Item> droppedItems;

    public Room(int lvl, int nrOfEnemies, int doors){
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
    
}


