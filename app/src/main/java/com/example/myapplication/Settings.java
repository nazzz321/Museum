package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences settings = getSharedPreferences("Settings", 0);
        SharedPreferences.Editor prefEditor = settings.edit();
        Button buttonSetDefaultSettings = findViewById(R.id.buttonSetDefaultSettings);
        Button buttonOnVoice = findViewById(R.id.buttonOnVoice);
        Button buttonOffVoice = findViewById(R.id.buttonOffVoice);
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonSetDefaultSettings.setOnClickListener(view -> {
            prefEditor.putInt("Mode", -1);
            prefEditor.apply();
        });
        buttonOnVoice.setOnClickListener(view -> {
            prefEditor.putInt("Mode", 1);
            prefEditor.apply();
        });
        buttonOffVoice.setOnClickListener(view -> {
            prefEditor.putInt("Mode", 0);
            prefEditor.apply();
        });
        buttonBack.setOnClickListener(view -> finish());
    }
}