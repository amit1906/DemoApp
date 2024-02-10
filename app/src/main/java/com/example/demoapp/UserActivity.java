package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class UserActivity extends AppCompatActivity {
    RadioButton male, female;
    Button btnLogOut, saveBtn, detailsBtn;
    TextView fName, lName, birth, city, savedLbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        btnLogOut = findViewById(R.id.btnLogOut);
        detailsBtn = findViewById(R.id.detailsBtn);
        saveBtn = findViewById(R.id.saveBtn);
        savedLbl = findViewById(R.id.savedLbl);
        fName = findViewById(R.id.firstName);
        lName = findViewById(R.id.lastName);
        birth = findViewById(R.id.birthDate);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        city = findViewById(R.id.city);

        fName.setText(UserData.FirstName);
        lName.setText(UserData.LastName);
        birth.setText(UserData.BirthDate);
        if (UserData.Gender == "זכר") {
            male.setChecked(true);
        } else if (UserData.Gender == "נקבה") {
            female.setChecked(true);
        }
        city.setText(UserData.City);

        male.setOnClickListener(view -> {
            female.setChecked(false);
        });
        female.setOnClickListener(view -> {
            male.setChecked(false);
        });

        saveBtn.setOnClickListener(view -> {
            UserData.FirstName = fName.getText().toString();
            UserData.LastName = lName.getText().toString();
            UserData.BirthDate = birth.getText().toString();
            if (male.isChecked()) {
                UserData.Gender = "זכר";
            } else if (female.isChecked()) {
                UserData.Gender = "נקבה";
            }
            UserData.City = city.getText().toString();

            savedLbl.setVisibility(View.VISIBLE);
            savedLbl.postDelayed(() -> savedLbl.setVisibility(View.GONE), 3000);
        });

        detailsBtn.setOnClickListener(view -> {
            finish();
            startActivity(new Intent(UserActivity.this, UserDetailsActivity.class));
        });

        btnLogOut.setOnClickListener(view -> finish());

    }
}