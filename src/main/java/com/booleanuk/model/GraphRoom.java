package com.booleanuk.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphRoom {

    private HashMap<Vertex, ArrayList<Vertex>> adjVertices;

    public GraphRoom() {
        adjVertices = new HashMap<>();
    }

    public Map<Vertex, ArrayList<Vertex>> getAdjVertex() {
        return adjVertices;
    }

    public void setAdjVertex(HashMap<Vertex, ArrayList<Vertex>> adjVertex) {
        this.adjVertices = adjVertex;
    }

    public void addVertex(Room room) {
        adjVertices.putIfAbsent(new Vertex(room), new ArrayList<>());
    }

    public void removeVertex(Room room) {
        Vertex v = new Vertex(room);
        adjVertices.values().stream().forEach(r -> r.remove(v));
        adjVertices.remove(new Vertex(room));
    }

    public void addEdge(Room room, Room room2) {
        Vertex v1 = new Vertex(room);
        Vertex v2 = new Vertex(room2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
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
