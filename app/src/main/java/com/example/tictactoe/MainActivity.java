package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.flexbox.FlexboxLayout;

public class MainActivity extends AppCompatActivity {

    private FlexboxLayout buttonsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonsLayout = findViewById(R.id.buttonsLayout);

        AddButtons();
    }

    private void AddButtons(){
        for (int i = 0; i < 9; i++){
            View view = getLayoutInflater().inflate(R.layout.game_button, null);
            GameButton gameButton = new GameButton(view);
            buttonsLayout.addView(view);
        } //
    }
}