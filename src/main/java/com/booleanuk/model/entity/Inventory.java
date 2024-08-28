package com.booleanuk.model.entity;

import com.booleanuk.model.item.Item;
import com.booleanuk.model.item.potion.HealthPotion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    HashMap<String, Item> items;
    int capacity;

    public Inventory(int capacity) {
        this.items = new HashMap<>();
        this.capacity = capacity;
    }

    public void addItemToInventory(Item item) {
        if (items.size() < capacity) {
            items.put(item.getId(), item);
        }
    }

    public ArrayList<Item> getItems() {
        return new ArrayList<>(items.values());
    }

    public boolean contains(String itemID) {
        return items.containsKey(itemID);
    }

    public boolean removeHealthPotion() {
        for (Map.Entry<String, Item> kvp : this.items.entrySet()) {
            if (kvp.getValue() instanceof HealthPotion) {
                this.items.remove(kvp.getKey());
                return true;
            }
        }
        return false;
    }

}
