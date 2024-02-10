package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public EditText useremailTxt, passTxt;
    Button loginBtn;
    TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        useremailTxt = findViewById(R.id.email);
        passTxt = findViewById(R.id.password);
        loginBtn = findViewById(R.id.btnLogIn);
        txtMessage = findViewById(R.id.txtMessage);
        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String user = useremailTxt.getText().toString();
                String pass = passTxt.getText().toString();

                if (user.isEmpty() && pass.isEmpty()) {
                    useremailTxt.setError("Provide user!");
                    passTxt.setError("Provide password!");
                    txtMessage.setText("Provide user and password!");
                    txtMessage.postDelayed(() -> txtMessage.setText("Welcome :)"), 3000);
                }
                else if (user.isEmpty()) {
                    useremailTxt.setError("Provide user!");
                    useremailTxt.requestFocus();
                    txtMessage.setText("Provide user!");
                    txtMessage.postDelayed(() -> txtMessage.setText("Welcome :)"), 3000);
                } else if (pass.isEmpty()) {
                    passTxt.setError("Provide password!");
                    passTxt.requestFocus();
                    txtMessage.setText("Provide password!");
                    txtMessage.postDelayed(() -> txtMessage.setText("Welcome :)"), 3000);
                } else if (!(user.isEmpty() && pass.isEmpty())) {
                    if (user.equals("Test") && pass.equals("1980")) {
                        startActivity(new Intent(MainActivity.this, UserActivity.class));
                    } else {
                        txtMessage.setText("Invalid credentials, try again.");
                        txtMessage.postDelayed(() -> txtMessage.setText("Welcome :)"), 3000);
                    }
                }
            }
        });
    }
}