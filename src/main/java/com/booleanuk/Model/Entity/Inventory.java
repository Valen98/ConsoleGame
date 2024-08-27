package com.booleanuk.Model.Entity;

import com.booleanuk.Model.Item.Item;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> items;
    int capacity;

    public Inventory(int capacity){
        this.capacity = capacity;
    }
}
