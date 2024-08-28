package com.booleanuk;

import com.booleanuk.Model.Entity.CharacterController;
import com.booleanuk.Model.Entity.Entity;
import com.booleanuk.Model.Entity.Player;
import com.booleanuk.Model.Item.Item;
import com.booleanuk.Model.Item.Weapon.Dagger;
import com.booleanuk.Model.Room;
import com.booleanuk.Model.Spell.Spell;

import java.util.ArrayList;

public class Game {
    IdGenerator idGenerator;
    private Player player;
    private CharacterController characterController;
    private ArrayList<Room> rooms;

    public Game(Player player) {
        this.idGenerator =  new IdGenerator();
        this.player = player;
        this.characterController = new CharacterController();
        this.rooms = new ArrayList<>();
    }

    public void attack(Entity attacker, Entity enemy){
       this.characterController.attack(attacker, enemy);
    }

    public void spellAttack(Spell spell, Entity attacker, Entity enemy){
        this.characterController.spellAttack(spell, attacker, enemy);
    }

    public void generateRooms() {
        for(int i = 0; i < 10; i++) {
            // this.rooms.add(new Room(roomLVL, nr_enemies, doors));
        }
    }

    public void addItemToEntity(Entity entity, Item item) {
        item.setId(idGenerator.generateId(10));
        entity.addItemToInventory(item);
    }

}
