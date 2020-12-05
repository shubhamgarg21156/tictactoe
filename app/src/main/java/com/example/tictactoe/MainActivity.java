package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;

    boolean isGameActive = true;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    int[] board={2,2,2,2,2,2,2,2,2};
    int[][] winningPositions ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    @SuppressLint("SetTextI18n")
    public void dropIn(View view){

        ImageView image =(ImageView) view;

        int tapped=Integer.parseInt(image.getTag().toString());

        if(isGameActive) {

            image.setTranslationY(-1500);

            board[tapped] = activePlayer;

            if (activePlayer == 0) {

                image.setImageResource(R.drawable.yellow);

                activePlayer = 1;

            } else {

                image.setImageResource(R.drawable.red);

                activePlayer = 0;
            }

            image.animate().translationYBy(1500).setDuration(500);
            image.setOnClickListener(null);
            for (int[] winningPosition : winningPositions) {

                if (board[winningPosition[0]] == board[winningPosition[1]] && board[winningPosition[1]] == board[winningPosition[2]] &&
                        board[winningPosition[2]] == board[winningPosition[0]] && board[winningPosition[0]] != 2
                ) {

                    isGameActive = false;
                    TextView textView = findViewById(R.id.textview);
                    Button button = findViewById(R.id.button);

                    if (activePlayer == 1) {

                        textView.setText("YELLOW HAS WON");

                    } else {

                        textView.setText("RED HAS WON");

                    }

                    button.setVisibility(View.VISIBLE);

                    return;

                }
            }

            boolean AllVisited=true;
            for(int i=0;i<9;i++){
                if(board[i]==2)AllVisited=false;
            }

            if(AllVisited){

                TextView textView = findViewById(R.id.textview);
                Button button = findViewById(R.id.button);
                textView.setText("DRAW");
                button.setVisibility(View.VISIBLE);
            }
        }
    }

    public void RestartGame(View view){

     finish();
     startActivity(getIntent());

    }
}
