package com.booleanuk;

import com.booleanuk.model.GraphRoom;
import com.booleanuk.model.Vertex;
import com.booleanuk.model.entity.CharacterController;
import com.booleanuk.model.entity.Entity;
import com.booleanuk.model.entity.Player;
import com.booleanuk.model.item.Item;
import com.booleanuk.model.Room;
import com.booleanuk.model.spell.Spell;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    IdGenerator idGenerator;
    private Player player;
    private CharacterController characterController;
    private ArrayList<Room> rooms;
    Random r;

    public Game(Player player) {
        this.idGenerator =  new IdGenerator();
        this.player = player;
        this.characterController = new CharacterController();
        this.rooms = new ArrayList<>();
        this.r = new Random();
    }

    public void attack(Entity attacker, Entity enemy){
       this.characterController.attack(attacker, enemy);
    }

    public void spellAttack(Spell spell, Entity attacker, Entity enemy){
        this.characterController.spellAttack(spell, attacker, enemy);
    }

    public void generateRooms() {
        GraphRoom graphRoom = new GraphRoom();

        for (int i = 0; i < 4; i++) {
            int numOfDoors = r.nextInt(1, 3);
            int randomEnemies = r.nextInt(3);
            Room room = new Room(idGenerator.generateId(5), 1, randomEnemies, numOfDoors);
            Vertex v1 = graphRoom.addVertex(room);
            for (int j = 0; j < numOfDoors; j++) {
                Room adjRoom = new Room(idGenerator.generateId(5),1,  randomEnemies, 1);
                Vertex v2 = graphRoom.addVertex(adjRoom);
                graphRoom.addEdge(v1, v2);
            }
        }
        /*
        Room room1 = new Room(idGenerator.generateId(5), 1, 2, 3);
        Room room2 = new Room(idGenerator.generateId(5), 1, 2, 1);
        Room room3 = new Room(idGenerator.generateId(5), 1, 2, 1);
        Room room4 = new Room(idGenerator.generateId(5), 1, 2, 2);
        Room room5 = new Room(idGenerator.generateId(5), 1, 2, 1);
        Vertex v1 = graphRoom.addVertex(room1);
        Vertex v2 = graphRoom.addVertex(room2);
        Vertex v3 = graphRoom.addVertex(room3);
        Vertex v4 = graphRoom.addVertex(room4);
        Vertex v5 = graphRoom.addVertex(room5);

        graphRoom.addEdge(v1, v2);
        graphRoom.addEdge(v1, v3);
        graphRoom.addEdge(v1, v4);
        graphRoom.addEdge(v4, v5);
            */
        System.out.println(graphRoom.getAdjVertex());
    }

    public void addItemToEntity(Entity entity, Item item) {
        item.setId(idGenerator.generateId(10));
        entity.addItemToInventory(item);
    }

}
