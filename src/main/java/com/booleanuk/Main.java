package com.booleanuk;

import com.booleanuk.model.entity.Player;

public class Main {
    public static void main(String[] args) {

        Game game = new Game(new Player("Lynx"));

        
        game.generateRooms();



    }
}