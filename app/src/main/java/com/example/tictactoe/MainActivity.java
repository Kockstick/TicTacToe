package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tictactoe.databinding.ActivityMainBinding;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private ArrayList<GameButton> buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        AddButtons();
    }

    private void AddButtons(){
        for (int i = 0; i < 9; i++){
            View view = getLayoutInflater().inflate(R.layout.game_button, null);
            GameButton gameButton = new GameButton(view);
            binding.buttonsLayout.addView(view);
            buttons.add(gameButton);
        }
    }
}