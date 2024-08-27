package com.booleanuk;

import com.booleanuk.Model.Entity.Entity;
import com.booleanuk.Model.Entity.Player;
import com.booleanuk.Model.Item.Item;
import com.booleanuk.Model.Item.Weapon.Dagger;

public class Game {
    IdGenerator idGenerator;
    private Player player;

    public Game() {
        this.idGenerator =  new IdGenerator();

    }

    public void addItemToEntity(Entity entity, Item item) {
        item.setId(idGenerator.generateId(10));
        entity.addItemToInventory(item);
    }


}
