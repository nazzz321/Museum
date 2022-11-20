package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button MainStart = (Button) findViewById(R.id.MainStart);
        Button AvailableStart = (Button) findViewById(R.id.AvailableStart);
        MainStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switcher = new Intent(MainActivity.this, IntroductionMain.class);
                MainActivity.this.startActivity(switcher);
            }
        });
       AvailableStart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent switcher = new Intent(MainActivity.this, IntroductionAvialible.class);
               MainActivity.this.startActivity(switcher);
           }
       });
    }


}