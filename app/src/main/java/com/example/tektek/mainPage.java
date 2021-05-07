package com.example.tektek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainPage extends AppCompatActivity {
    //boy-kilo girmeye geri gönderiyo
    public void goUpdateValues(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    //su eklemeye gönderiyo
    public void addWaterScreen(){
        Intent intent = new Intent(this, waterPop.class);
        startActivity(intent);
    }
    public void getUsernameEnter(){
        Intent intent = new Intent(this, usernamePop.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        //yukardaki metodları çalıştıracak butonlara girdim.
        Button updater;
        Button waterAdder;
        Button simdilik;
        waterAdder=findViewById(R.id.addwaterbutton);
        waterAdder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addWaterScreen();
            }
        });
        updater = findViewById(R.id.updatevalues);
        updater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goUpdateValues();
            }
        });
        simdilik=findViewById(R.id.reminder);
        simdilik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsernameEnter();
            }
        });
    }
}