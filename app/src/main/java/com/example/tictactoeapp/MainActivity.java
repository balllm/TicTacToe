package com.example.tictactoeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static String playerSymbol;
    static String[][] matrix;
    TextView textView;
    boolean key = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text1);
        playerSymbol = "X";
        matrix = new String[3][3];
    }

    public void buttonClicked(View view){
        Button button = findViewById(view.getId());
        String tag = button.getTag().toString();
        String[] numbers = tag.split("#");

        int row = Integer.parseInt(numbers[0]);
        int col = Integer.parseInt(numbers[1]);

        if(key == true){
            if(checkPos(row, col)){
                // внутри button чтобы после того как key становится false мы не могли дальше выбирать
                button.setText(playerSymbol);
                matrix[row][col] = playerSymbol;

                switchPlayer();
                checkWinner();
                if(checkWinner()){
                    key = false;
                }

            }else{
                Toast.makeText(this, "Место занято ", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Победитель: " + playerSymbol, Toast.LENGTH_SHORT).show();
        }
    }


    public void switchPlayer(){
        if (playerSymbol == "X")
            playerSymbol = "O";
        else
            playerSymbol = "X";
    }

    public boolean checkWinner() {
        // проверка по горизонтали
        for (int row = 0; row < matrix.length; row++) {
            int count = 0;
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == playerSymbol) {
                    count++;
                }
            }
            if (count == 3) {
                textView.setText("Победитель: " + playerSymbol);
                return true;
            }
        }
        // проверка по вертикали
        for (int row = 0; row < matrix.length; row++) {
            int count2 = 0;
            for (int col = 0; col < matrix.length; col++) {
                if(matrix[col][row] == playerSymbol){
                    count2++;
                }
            }
            if(count2 == 3){
                textView.setText("Победитель: " + playerSymbol);
                return true;
            }
        }
        // проверка по диагоали
        int countD1 = 0;
        for (int row = 0; row < matrix.length; row++) {
            if(matrix[row][row] == playerSymbol){
                countD1++;
            }
            if(countD1 == 3){
                textView.setText("Победитель: " + playerSymbol);
                return true;
            }
        }

        int countD2 = 0;
        int k = 2;
        for (int row = 0; row < matrix.length; row++) {
            if(matrix[row][k] == playerSymbol){
                countD2++;
                k--;
            }
            if(countD2 == 3){
                textView.setText("Победитель: " + playerSymbol);
                return true;
            }
        }

        return false;
    }
    public static boolean checkPos(int row, int col){
        if(matrix[row][col] != null){
            return false;
        }else{
            return true;
        }
    }

    public void reset(View view) {
        key = true;
        playerSymbol = "X";
        textView.setText("");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                //
            }
        }
    }

}