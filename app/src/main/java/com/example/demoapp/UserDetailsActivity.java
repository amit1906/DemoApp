package com.example.demoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class UserDetailsActivity extends AppCompatActivity {
    Button btnLogOut;
    TextView backBtn,fName ,lName ,birth ,gender ,city ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        btnLogOut = findViewById(R.id.btnLogOut);
        backBtn = findViewById(R.id.backBtn);
        fName = findViewById(R.id.fname);
        lName = findViewById(R.id.lname);
        birth = findViewById(R.id.birth);
        gender = findViewById(R.id.gender);
        city = findViewById(R.id.city);

        fName.setText(UserData.FirstName);
        lName.setText(UserData.LastName);
        birth.setText(UserData.BirthDate);
        gender.setText(UserData.Gender);
        city.setText(UserData.City);

        backBtn.setOnClickListener(view -> {
            finish();
            startActivity(new Intent(UserDetailsActivity.this, UserActivity.class));
        });

        btnLogOut.setOnClickListener(view -> finish());

    }
}