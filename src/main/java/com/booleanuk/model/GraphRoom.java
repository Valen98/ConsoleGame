package com.booleanuk.model;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphRoom {

    private HashMap<Vertex, ArrayList<Vertex>> adjVertices;
    public GraphRoom() {
        adjVertices = new HashMap<>();

    }

    public HashMap<Vertex, ArrayList<Vertex>> getAdjVertex() {
        return adjVertices;
    }

    public void setAdjVertex(HashMap<Vertex, ArrayList<Vertex>> adjVertex) {
        this.adjVertices = adjVertex;
    }

    public Vertex addVertex(Room room) {
        Vertex v1 = new Vertex(room);
        adjVertices.putIfAbsent(v1, new ArrayList<>());
        System.out.println(adjVertices);
        return v1;
    }

    public void removeVertex(Room room) {
        Vertex v = new Vertex(room);
        adjVertices.values().stream().forEach(r -> r.remove(v));
        adjVertices.remove(new Vertex(room));
    }



    public void addEdge(Vertex v1, Vertex v2) {
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);

        System.out.println(v1.getRoom().getId() + " -> " + v2.getRoom().getId());

    }

    public void removeEdge(Room room, Room room2) {
        Vertex v1 = new Vertex(room);
        Vertex v2 = new Vertex(room2);
        ArrayList<Vertex> eV1 = adjVertices.get(v1);
        ArrayList<Vertex> eV2 = adjVertices.get(v2);

        if(eV1 != null) {
            eV1.remove(v2);
        }
        if(eV2 != null) {
            eV2.remove(v1);
        }
    }
}
