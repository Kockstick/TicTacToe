package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.tictactoe.databinding.ActivityMainBinding;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FlexboxLayout buttonsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameManager.Start();

        buttonsLayout = findViewById(R.id.buttonsLayout);

        AddNineButtons();
    }

    private void AddNineButtons(){
        for (int i = 0; i < 9; i++){
            AddButton();
        }
    }

    private  void AddButton(){
        Button button = new Button(this);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.height = convertToDp(100);
        params.width = convertToDp(100);
        button.setLayoutParams(params);

        buttonsLayout.addView(button);

        button.setTextSize(25);

        button.setOnClickListener(v -> {
            Button btn = (Button)v;
            btn.setText(GameManager.player.symbol);
            btn.setClickable(false);
            GameManager.Next();
        });
    }

    private int convertToDp(int pt){
        float destiny = getApplicationContext().getResources().getDisplayMetrics().density;
        return (int)(pt * destiny + 0.5);
    }
}