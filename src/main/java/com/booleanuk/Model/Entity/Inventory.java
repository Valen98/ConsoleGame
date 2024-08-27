package com.booleanuk.Model.Entity;

import com.booleanuk.Model.Item.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    HashMap<String, Item> items;
    int capacity;

    public Inventory(int capacity){
        this.items = new HashMap<>();
        this.capacity = capacity;
    }

    public void addItemToInventory(Item item) {
        if(items.size() < capacity){
            items.put(item.getId(), item);
        }
    }

    public ArrayList<Item> getItems() {
        return new ArrayList<>(items.values());
    }

    public boolean contains(String itemID) {
        return items.containsKey(itemID);
    }
}
