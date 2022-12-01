package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech TTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonSettings = findViewById(R.id.buttonSettings);
        Button buttonAbout = findViewById(R.id.buttonAbout);
        Button buttonStart = findViewById(R.id.buttonStart);

        SharedPreferences settings = getSharedPreferences("Settings", 0);

        TTS = new TextToSpeech(this, initStatus -> {});
        TTS.setLanguage(new Locale("ru"));

        if (settings.getInt("Mode", -1) == -1) {
            Intent intent = new Intent(this, SetMode.class);
            startActivity(intent);
        }
        buttonStart.setOnClickListener(view -> {
            if (settings.getInt("Mode", -1) == 1) {
                TTS.speak("Начать экскурсию",TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        buttonSettings.setOnClickListener(view -> {
            if (settings.getInt("Mode", -1) == 1) {
                TTS.speak("Настройки",TextToSpeech.QUEUE_FLUSH,null);
            }
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
        });
        buttonAbout.setOnClickListener(view -> {
            if (settings.getInt("Mode", -1) == 1) {
                TTS.speak("Об авторах",TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}