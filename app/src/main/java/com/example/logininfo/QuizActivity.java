package com.example.logininfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private TextView num1, num2, operator;
    private EditText answer;
    private int correct, total, currOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        num1 = findViewById(R.id.textView);
        num2 = findViewById(R.id.textView2);
        answer = findViewById(R.id.editTextNumber);
        operator = findViewById(R.id.mathTypeTextView);

        total = -1;

        Toast.makeText(getBaseContext(), "Welcome username", Toast.LENGTH_LONG).show();

    }



    public void generate(View view) {
        if(total >= 10 || total == -1){
            total = 0;
            correct = 0;

            Random rand = new Random();

            num1.setText(String.valueOf(rand.nextInt(100)));
            num2.setText(String.valueOf(rand.nextInt(20)));
            newOperator();

            total ++;
        } else {
            String res = "Cannot start a new game while in a current game";
            Toast.makeText(getBaseContext(), res, Toast.LENGTH_SHORT).show();
        }
    }

    public void submit(View view) {

        if(total == -1)
            return;

        int n1 = Integer.valueOf(num1.getText().toString());
        int n2 = Integer.valueOf(num2.getText().toString());

        if(currOperator == 1 ) {
            if(n1 + n2 == Integer.valueOf(answer.getText().toString())) correct++;
        } else {
            if(n1 - n2 == Integer.valueOf(answer.getText().toString())) correct++;
        }

        if(total == 10) {

            String res = "You got " + correct + " answers right";
            Toast.makeText(getBaseContext(), res, Toast.LENGTH_LONG).show();

            num1.setText("Done");
            num2.setText("Done");

            total = -1;

        } else {
            Random rand = new Random();

            num1.setText(String.valueOf(rand.nextInt(100)));
            num2.setText(String.valueOf(rand.nextInt(20)));
            newOperator();
        }

        total++;
    }

    public void newOperator(){ //50 50 for addition or subtraction
        Random rand = new Random();

        int x = rand.nextInt(100);
        if(x < 50) {
            operator.setText("Subtraction");
            currOperator = 0;
        } else {
            operator.setText("Addition");
            currOperator = 1;
        }
    }
}