package com.booleanuk.model.entity;

import com.booleanuk.IdGenerator;
import com.booleanuk.model.spell.Spell;

import java.util.HashMap;

public class CharacterController {

    private HashMap<String, Entity> characterList;
    private IdGenerator idGenerator;

    public CharacterController(){
        this.characterList = new HashMap<>();
        this.idGenerator = new IdGenerator();
    }

    public HashMap<String, Entity> getCharacterList(){
        return this.characterList;
    }

    public void addCharacter(Entity entity){
        String id = idGenerator.generateId(10);
        entity.setId(id);
        this.characterList.put(id, entity);
    }

    public Entity getCharacter(String id) {
        return characterList.get(id);
    }

    public void attack(Entity attacker, Entity enemy){
        enemy.getAttacked(attacker.getWeapon());
    }

    public void spellAttack(Spell spell, Entity attacker, Entity enemy){
        if (!attacker.getSpells().contains(spell) || attacker.getMana() < spell.getManaCost()){
            return;
        }

        enemy.getAttacked(spell);
        attacker.decreaseMana(spell.getManaCost());

    }




}
