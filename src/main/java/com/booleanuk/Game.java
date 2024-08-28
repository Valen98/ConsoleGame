package com.booleanuk;

import com.booleanuk.Model.Entity.CharacterController;
import com.booleanuk.Model.Entity.Entity;
import com.booleanuk.Model.Entity.Player;
import com.booleanuk.Model.Item.Item;
import com.booleanuk.Model.Item.Weapon.Dagger;
import com.booleanuk.Model.Spell.Spell;

public class Game {
    IdGenerator idGenerator;
    private Player player;
    private CharacterController characterController;

    public Game(Player player) {
        this.idGenerator =  new IdGenerator();
        this.player = player;
        this.characterController = new CharacterController();

    }

    public void attack(Entity attacker, Entity enemy){
       this.characterController.attack(attacker, enemy);
    }

    public void spellAttack(Spell spell, Entity attacker, Entity enemy){
        this.characterController.spellAttack(spell, attacker, enemy);
    }

    public void addItemToEntity(Entity entity, Item item) {
        item.setId(idGenerator.generateId(10));
        entity.addItemToInventory(item);
    }


}
