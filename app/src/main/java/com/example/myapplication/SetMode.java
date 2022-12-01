package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

public class SetMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_mode);
        SharedPreferences settings = getSharedPreferences("Settings", 0);
        SharedPreferences.Editor prefEditor = settings.edit();
        Button buttonSetDef = findViewById(R.id.buttonSetDef);
        Button buttonSetAva = findViewById(R.id.buttonSetAva);
        buttonSetDef.setOnClickListener(view -> {
            prefEditor.putInt("Mode", 0);
            prefEditor.apply();
            finish();
        });
        buttonSetAva.setOnClickListener(view -> {
            prefEditor.putInt("Mode", 1);
            prefEditor.apply();
            finish();
        });
    }
}