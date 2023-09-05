package com.example.tictactoe;

import android.view.View;

public class GameButton {

    private View view;
    private Player player;

    public  GameButton(View view){
        this.view = view;
    }

    public void Click(Player player){
        this.player = player;
    }
}
