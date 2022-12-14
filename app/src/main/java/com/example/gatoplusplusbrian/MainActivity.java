package com.example.gatoplusplusbrian;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[6][6];

    private boolean jugador1Turno = true;
    private int contador;
    private int jugador1Puntos;
    private int jugador2Puntos;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }
    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (jugador1Turno) {
            ((Button) v).setText("X");

        } else {
            ((Button) v).setText("O");

        }

        contador++;

        if (checkForWin()) {
            if (jugador1Turno) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (contador == 36) {
            draw();
        } else {
            jugador1Turno = !jugador1Turno;
        }

    }
    private boolean checkForWin() {
        String[][] field = new String[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 6; i++) {
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && field[i][0].equals(field[i][3]) && !field[i][0].equals("")) {
                return true;
            }
            if (field[i][1].equals(field[i][2]) && field[i][1].equals(field[i][3]) && field[i][1].equals(field[i][4]) && !field[i][1].equals("")) {
                return true;
            }
            if (field[i][2].equals(field[i][3]) && field[i][2].equals(field[i][4]) && field[i][2].equals(field[i][5]) && !field[i][2].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 6; i++) {
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && field[0][i].equals(field[3][i]) && !field[0][i].equals("")) {
                return true;
            }
            if (field[1][i].equals(field[2][i]) && field[1][i].equals(field[3][i]) && field[1][i].equals(field[4][i]) && !field[1][i].equals("")) {
                return true;
            }
            if (field[2][i].equals(field[3][i]) && field[2][i].equals(field[4][i]) && field[2][i].equals(field[5][i]) && !field[2][i].equals("")) {
                return true;
            }
            if (field[0][2].equals(field[1][3]) && field[0][2].equals(field[2][4]) && field[0][2].equals(field[3][5]) && !field[0][2].equals("")) {
                return true;
            }
            if (field[0][1].equals(field[1][2]) && field[0][1].equals(field[2][3]) && field[0][1].equals(field[3][4]) && !field[0][1].equals("")) {
                return true;
            }
            if (field[0][0].equals(field[1][1]) && field[0][1].equals(field[2][2]) && field[0][1].equals(field[3][3]) && !field[0][1].equals("")) {
                return true;
            }
            if (field[1][2].equals(field[2][3]) && field[1][2].equals(field[3][4]) && field[1][2].equals(field[4][5]) && !field[1][2].equals("")) {
                return true;
            }

            if (field[1][1].equals(field[2][2]) && field[1][1].equals(field[3][3]) && field[1][1].equals(field[4][4]) && !field[1][1].equals("")) {
                return true;
            }
            if (field[2][2].equals(field[3][3]) && field[2][2].equals(field[4][4]) && field[2][2].equals(field[5][5]) && !field[2][2].equals("")) {
                return true;
            }
            if (field[1][2].equals(field[2][3]) && field[1][2].equals(field[3][4]) && field[1][2].equals(field[4][5]) && !field[1][2].equals("")) {
                return true;
            }
            if (field[0][2].equals(field[1][3]) && field[0][2].equals(field[2][4]) && field[0][2].equals(field[3][5]) && !field[0][2].equals("")) {
                return true;
            }


            if (field[5][2].equals(field[4][3]) && field[5][2].equals(field[3][4]) && field[5][2].equals(field[2][5]) && !field[5][2].equals("")) {
                return true;
            }
            if (field[4][2].equals(field[3][3]) && field[4][2].equals(field[2][4]) && field[4][2].equals(field[1][5]) && !field[4][2].equals("")) {
                return true;
            }
            if (field[3][2].equals(field[2][3]) && field[3][2].equals(field[1][4]) && field[3][2].equals(field[0][5]) && !field[3][2].equals("")) {
                return true;
            }
            if (field[5][1].equals(field[4][2]) && field[5][1].equals(field[3][3]) && field[5][1].equals(field[2][4]) && !field[5][1].equals("")) {
                return true;
            }

            if (field[4][1].equals(field[3][2]) && field[4][1].equals(field[2][3]) && field[4][1].equals(field[1][4]) && !field[4][1].equals("")) {
                return true;
            }
            if (field[3][1].equals(field[2][2]) && field[3][1].equals(field[1][3]) && field[3][1].equals(field[0][4]) && !field[3][1].equals("")) {
                return true;
            }
            if (field[5][0].equals(field[4][1]) && field[5][0].equals(field[3][2]) && field[5][0].equals(field[2][3]) && !field[5][0].equals("")) {
                return true;
            }
        }



        return false;
    }

    private void player1Wins() {
        jugador1Puntos++;
        Toast.makeText(this, "??Jugador 1 gana!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void player2Wins() {
        jugador2Puntos++;
        Toast.makeText(this, "??Jugador 2 gana!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void draw() {
        Toast.makeText(this, "??Empate!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePointsText() {
        textViewPlayer1.setText("Jugador 1: " + jugador1Puntos);
        textViewPlayer2.setText("Jugador 2: " + jugador2Puntos);
    }

    private void resetBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                buttons[i][j].setText("");

            }
        }

        contador = 0;
        jugador1Turno = true;
    }

    private void resetGame() {
        jugador1Puntos = 0;
        jugador2Puntos = 0;
        updatePointsText();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", contador);
        outState.putInt("player1Points", jugador1Puntos);
        outState.putInt("player2Points", jugador2Puntos);
        outState.putBoolean("player1Turn", jugador1Turno);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        contador = savedInstanceState.getInt("roundCount");
        jugador1Puntos = savedInstanceState.getInt("player1Points");
        jugador2Puntos = savedInstanceState.getInt("player2Points");
        jugador1Turno = savedInstanceState.getBoolean("jugador1Turno");
    }


}