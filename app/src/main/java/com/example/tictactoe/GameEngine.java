package com.example.tictactoe;

import android.widget.Button;

import java.util.ArrayList;

public class GameEngine {

    public static ArrayList<Button> buttons = new ArrayList<>();

    public static boolean checkWin(String symbol) {
        for (int i = 0; i < 3; i++) {
            if (buttons.get(i).getText().equals(symbol) && buttons.get(i + 3).getText().equals(symbol) && buttons.get(i + 6).getText().equals(symbol))
                return true;
            if (buttons.get(i * 3).getText().equals(symbol) && buttons.get(i * 3 + 1).getText().equals(symbol) && buttons.get(i * 3 + 2).getText().equals(symbol))
                return true;
        }

        if (buttons.get(0).getText().equals(symbol) && buttons.get(4).getText().equals(symbol) && buttons.get(8).getText().equals(symbol))
            return true;
        if (buttons.get(2).getText().equals(symbol) && buttons.get(4).getText().equals(symbol) && buttons.get(6).getText().equals(symbol))
            return true;

        return false;
    }

    public static void restart(){
        for (Button itm : buttons){
            itm.setText("");
            itm.setClickable(true);
            itm.setBackgroundResource(R.drawable.rounded_rect);
        }
        GameManager.isGame = true;
    }
}
