package com.booleanuk.model;

public class Vertex {
    Room room;
    Vertex(Room room) {
        this.room = room;
    }

    public Vertex getVertex() {
        return this;
    }

    public Room getRoom() {
        return room;
    }
}
