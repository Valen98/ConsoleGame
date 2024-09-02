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
    private  GraphRoom graphRoom;
    Random r;
    private Vertex currentVertex;
    private final int totalRooms = 10;
    private ArrayList<Vertex> vertexArrayList;


    public Game(Player player) {
        this.idGenerator =  new IdGenerator();
        this.player = player;
        this.characterController = new CharacterController();
        this.graphRoom = new GraphRoom();
        this.r = new Random();
        this.vertexArrayList = new ArrayList<>();
    }

    public void attack(Entity attacker, Entity enemy){
       this.characterController.attack(attacker, enemy);
    }

    public void spellAttack(Spell spell, Entity attacker, Entity enemy){
        this.characterController.spellAttack(spell, attacker, enemy);
    }

    public void generateRooms() {
        for (int i = 0; i < 4; i++) {
            int numOfDoors = r.nextInt(1, 3);
            int randomEnemies = r.nextInt(3);
            Vertex v1 = graphRoom.addVertex(createRoom(randomEnemies, numOfDoors));
            this.vertexArrayList.add(v1);
            if(i == 0) {
                //Starting position
                currentVertex = v1;
            }
        }
        System.out.println("Rooms = " + vertexArrayList);
        for (int i = 0; i < this.totalRooms; i++) {
            System.out.println(this.vertexArrayList.get(i).getRoom().getId());
            for (int j = 0; j < this.vertexArrayList.get(i).getRoom().getDoors(); j++) {
                Vertex parentVertex = this.vertexArrayList.get(i);
                int numOfDoors = r.nextInt(1, 3);
                int randomEnemies = r.nextInt(3);
                Vertex neighbor = graphRoom.addVertex(createRoom(randomEnemies, numOfDoors));
                this.vertexArrayList.add(neighbor);
                graphRoom.addEdge(parentVertex, neighbor);
            }
            //System.out.println("adj vertex for " + vertexArrayList.get(i) + " linked to " + graphRoom.getAdjVerticesOfVertex(vertexArrayList.get(i)));
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
        //System.out.println(graphRoom.getAdjVertex());
    }

    public Room createRoom(int randomEnemies, int numOfDoors) {
        return new Room(idGenerator.generateId(5), 1, randomEnemies, numOfDoors);
    }

    public Vertex getCurrentVertex() {
        //System.out.println(currentVertex.getRoom().getId());
        return currentVertex;
    }

    public GraphRoom getGraphRoom() {
        return graphRoom;
    }

    public Vertex goIntoVertex(int roomNum) {
        if(roomNum < getGraphRoom().getAdjVerticesOfVertex(currentVertex).size()) {
            this.currentVertex = getGraphRoom().getAdjVerticesOfVertex(currentVertex).get(roomNum);
        }
        return this.currentVertex;
    }

    public ArrayList<Vertex> getVertexArrayList() {
        return vertexArrayList;
    }

    public void addItemToEntity(Entity entity, Item item) {
        item.setId(idGenerator.generateId(10));
        entity.addItemToInventory(item);
    }

}
