package com.ardakazanci.tictactoeoyunu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    // Seçilen Buttonlar
    public void buttonEventClick(View view) {
        /* view Referansı Button'a cast ediliyor.  */
        Button button = (Button) view;

        int buttonID = 0; // Seçilen buttonun id ' sini tutacak


        /* Seçilen button ID 'si buttonID değişkenine aktarılıyor. */
        switch ((button.getId())) {

            case R.id.bt1:
                buttonID = 1;
                break;

            case R.id.bt2:
                buttonID = 2;
                break;
            case R.id.bt3:
                buttonID = 3;
                break;
            case R.id.bt4:
                buttonID = 4;
                break;
            case R.id.bt5:
                buttonID = 5;
                break;
            case R.id.bt6:
                buttonID = 6;
                break;
            case R.id.bt7:
                buttonID = 7;
                break;
            case R.id.bt8:
                buttonID = 8;
                break;
            case R.id.bt9:
                buttonID = 9;
                break;


        }

        playGame(buttonID, button);


    }
    // Seçilen Buttonlar Son


    // Aktif Kullanıcı Sırası
    int activePlayer = 1;
    ArrayList<Integer> Player1 = new ArrayList<Integer>();
    ArrayList<Integer> Player2 = new ArrayList<Integer>();

    private void playGame(int buttonID, Button button) {

        if (activePlayer == 1) {
            button.setText("X");
            button.setBackgroundColor(Color.GREEN);
            Player1.add(buttonID);
            activePlayer = 2;
            AutoPlay();


        } else if (activePlayer == 2) {
            button.setText("O");
            button.setBackgroundColor(Color.BLUE);
            Player2.add(buttonID);
            activePlayer = 1;

        }

        button.setEnabled(false); // Seçim yapıldıktan sonra tekrar seçim yapılamaz. Button inaktif duruma gelir.
        checkWinner();

    }

    private void checkWinner() {

        int Winer = -1;

        //row 1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)) {
            Winer = 1;
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)) {
            Winer = 2;
        }

        //row 2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)) {
            Winer = 1;
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)) {
            Winer = 2;
        }

        //row 3
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)) {
            Winer = 1;
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)) {
            Winer = 2;
        }


        //col 1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)) {
            Winer = 1;
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)) {
            Winer = 2;
        }

        //col 2
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)) {
            Winer = 1;
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)) {
            Winer = 2;
        }


        //col 3
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)) {
            Winer = 1;
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)) {
            Winer = 2;
        }


        if (Winer != -1) {
            // We have winer

            if (Winer == 1) {
                Toast.makeText(this, "Oyuncu 1 kazandı", Toast.LENGTH_LONG).show();
            }

            if (Winer == 2) {
                Toast.makeText(this, "Oyuncu 2 kazandı", Toast.LENGTH_LONG).show();
            }


        }

        // Aktif Kullanıcı Sırası Son


    }


    void AutoPlay() {

        ArrayList<Integer> EmptyCells = new ArrayList<Integer>(); // all un selected cells
        //Find empty cells

        for (int cellID = 1; cellID < 10; cellID++) {
            if (!(Player1.contains(cellID) || Player2.contains(cellID))) {
                EmptyCells.add(cellID);
            }
        }

        Random r = new Random();
        int RandIndex = r.nextInt(EmptyCells.size() - 0) + 0; // if size =3 , select (0,1,2)
        int CellID = EmptyCells.get(RandIndex);

        Button buSelected;
        switch (CellID) {

            case 1:
                buSelected = (Button) findViewById(R.id.bt1);
                break;

            case 2:
                buSelected = (Button) findViewById(R.id.bt2);
                break;

            case 3:
                buSelected = (Button) findViewById(R.id.bt3);
                break;

            case 4:
                buSelected = (Button) findViewById(R.id.bt4);
                break;

            case 5:
                buSelected = (Button) findViewById(R.id.bt5);
                break;

            case 6:
                buSelected = (Button) findViewById(R.id.bt6);
                break;

            case 7:
                buSelected = (Button) findViewById(R.id.bt7);
                break;

            case 8:
                buSelected = (Button) findViewById(R.id.bt8);
                break;

            case 9:
                buSelected = (Button) findViewById(R.id.bt9);
                break;
            default:
                buSelected = (Button) findViewById(R.id.bt1);
                break;

        }
        playGame(CellID, buSelected);
    }

}
