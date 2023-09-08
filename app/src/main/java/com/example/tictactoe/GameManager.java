package com.example.tictactoe;

import java.util.ArrayList;

public class GameManager {

    private static ArrayList<Player> players = new ArrayList<Player>();
    public static Player player;
    public static boolean isGame = true;

    public static void Start(){
        players.add(new Player(0, "Kockstik", "X"));
        players.add(new Player(1, "Dasha", "0"));

        player = players.get(0);
    }

    public static Player GetNextPlayer(){
        int id = player.id + 1;
        if(id >= players.size())
            id = 0;

        return players.get(id);
    }

    public static void Next(){
        player = GetNextPlayer();
    }
}
