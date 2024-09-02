package com.booleanuk;

import com.booleanuk.model.GraphRoom;
import com.booleanuk.model.Vertex;
import com.booleanuk.model.entity.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(new Player("Lynx"));

        game.generateRooms();


        Vertex currentVertex = game.getCurrentVertex();
        GraphRoom graphRoom = game.getGraphRoom();

        //System.out.println(graphRoom.getAdjVerticesOfVertex(currentVertex.getVertex()));

        /*
        for (Vertex vertex: graphRoom.getAdjVerticesOfVertex(currentVertex)) {
            System.out.println("Current vertex " + currentVertex.getRoom().getId());
            System.out.println("Neighbor room: " + vertex.getRoom().getId());
            System.out.println("Link is :" +currentVertex.getRoom().getId() + " -> " + vertex.getRoom().getId());
        }

         */

        for (Vertex vertex: game.getVertexArrayList()) {
            for (Vertex v : graphRoom.getAdjVerticesOfVertex(vertex)) {
                System.out.println("-----------------------------------");
                System.out.println("Current vertex " + vertex.getRoom().getId());
                System.out.println("Neighbor room: " + v.getRoom().getId());
                System.out.println("Link is :" + vertex.getRoom().getId() + " -> " + v.getRoom().getId());
            }
        }

        
        boolean quit = true;
        int checker = 0;
        while (quit) {

            int counter = 0;
            System.out.println("Current room is: " + currentVertex.getRoom().getId());
            for (Vertex vertex: graphRoom.getAdjVerticesOfVertex(currentVertex)) {
              System.out.println(counter + " to get into Room: " + vertex.getRoom().getId());
              counter++;
            }


            int userInput = scanner.nextInt();

            currentVertex = game.goIntoVertex(userInput);

            checker++;
            System.out.println(checker);

            if(userInput == -1) quit = false;
        }

        /* 
        System.out.println("Before going into a new room " + currentVertex +" "+ currentVertex.getRoom().getId());

        currentVertex = game.goIntoVertex(currentVertex.getRoom().getDoors() - 1);

        System.out.println("After going to a new room " + currentVertex +" "+ currentVertex.getRoom().getId());

        System.out.println("New neighbor room = " + graphRoom.getAdjVerticesOfVertex(currentVertex) + " "+ currentVertex.getRoom().getId());

        currentVertex = game.goIntoVertex(5);

        System.out.println("Vertex test  doors = " + (currentVertex.getRoom().getDoors() - 1) +  ", " + currentVertex + " "+ currentVertex.getRoom().getId() + " neighbor " + currentVertex.getRoom().getDoors());

        currentVertex = game.goIntoVertex(currentVertex.getRoom().getDoors() - 1);

        System.out.println("Vertex test  doors = " + (currentVertex.getRoom().getDoors() - 1) +  ", " + currentVertex + " "+ currentVertex.getRoom().getId() + " neighbor " + currentVertex.getRoom().getDoors());

        currentVertex = game.goIntoVertex(0);

        System.out.println("Vertex test  doors = " + currentVertex.getRoom().getDoors() +  ", " + currentVertex + " "+ currentVertex.getRoom().getId() + " neighbor " + currentVertex.getRoom().getDoors());
         */
    }
}