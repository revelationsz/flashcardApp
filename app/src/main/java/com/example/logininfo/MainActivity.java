package com.example.logininfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String username, password;
    private EditText usernameInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.username = getString(R.string.username);
        this.password = getString(R.string.password);

        Button submit = findViewById(R.id.loginButton);
        usernameInput = findViewById(R.id.usernameEditText);
        passwordInput = findViewById(R.id.passwordEditText);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterInfo();
            }
        });

    }

    public void enterInfo(){
        if(usernameInput.getText().toString().equals(username) && passwordInput.getText().toString().equals(password)){
            Intent intent = new Intent(this, QuizActivity.class);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}