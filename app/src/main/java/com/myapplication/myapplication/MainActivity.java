package com.myapplication.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
    int activePlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playerTap(View view)
    {
        ImageView img=(ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        {
            gameReset(view);
        }
        if(gameState[tappedImage]==2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.cross);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            } else {
                img.setImageResource(R.drawable.zero);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winPosition: winPositions)
        {
            if(gameState[winPosition[0]]==gameState[winPosition[1]] && gameState[winPosition[1]]==gameState[winPosition[2]] && gameState[winPosition[0]]!=2)
            {
                String winnerStr;
                gameActive=false;
                if (gameState[winPosition[0]]==0)
                {
                    winnerStr="X has won";
                }
                else
                {
                      winnerStr="O has won";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }


    }

    public void gameReset(View view)
    {
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.zero1)).setImageResource(0);
        ((ImageView)findViewById(R.id.zero2)).setImageResource(0);
        ((ImageView)findViewById(R.id.zero3)).setImageResource(0);
        ((ImageView)findViewById(R.id.zero4)).setImageResource(0);
        ((ImageView)findViewById(R.id.zero5)).setImageResource(0);
        ((ImageView)findViewById(R.id.zero6)).setImageResource(0);
        ((ImageView)findViewById(R.id.zero7)).setImageResource(0);
        ((ImageView)findViewById(R.id.zero8)).setImageResource(0);
        ((ImageView)findViewById(R.id.zero9)).setImageResource(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}