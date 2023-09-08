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
    private Button restartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameManager.Start();

        buttonsLayout = findViewById(R.id.buttonsLayout);
        restartBtn = findViewById(R.id.restart_button);

        RestartBtnReceiver();
        AddNineButtons();
    }

    private void AddNineButtons(){
        for (int i = 0; i < 9; i++){
            AddButton();
        }
    }

    private  void AddButton(){
        Button button = new Button(this);

        SetButtonProperties(button);

        GameEngine.buttons.add(button);

        button.setOnClickListener(v -> OnClick(v));
    }

    private void SetButtonProperties(Button button){
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.height = convertToDp(50);
        params.width = convertToDp(50);
        button.setLayoutParams(params);

        buttonsLayout.addView(button);

        button.setTextColor(00000000);

        button.setBackgroundResource(R.drawable.rounded_rect);

        button.setTextSize(25);

        ViewGroup.MarginLayoutParams margins = (ViewGroup.MarginLayoutParams) button.getLayoutParams();
        int marginDp = convertToDp(25);
        margins.setMargins(marginDp, marginDp, marginDp, marginDp);
        button.setLayoutParams(margins);
    }

    private void OnClick(View v){
        if(!GameManager.isGame)
            return;

        Button button = (Button)v;
        button.setText(GameManager.player.symbol);

        if(GameManager.player.symbol.equals("0"))
            button.setBackgroundResource(R.drawable.zero);
        else
            button.setBackgroundResource(R.drawable.cross);

        button.setClickable(false);
        if(GameEngine.checkWin(GameManager.player.symbol))
        {
            Toast.makeText(this, GameManager.player.name + " won!!!", Toast.LENGTH_SHORT).show();
            GameManager.isGame = false;
            return;
        }
        GameManager.Next();
    }

    private int convertToDp(int pt){
        float destiny = getApplicationContext().getResources().getDisplayMetrics().density;
        return (int)(pt * destiny + 0.5);
    }

    private void RestartBtnReceiver(){
        restartBtn.setOnClickListener(v -> {
            GameEngine.restart();
        });
    }
}