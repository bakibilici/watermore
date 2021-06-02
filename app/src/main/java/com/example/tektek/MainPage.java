package com.example.tektek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tektek.database.UserTable;
import com.example.tektek.viewmodel.DbViewModel;

public class MainPage extends AppCompatActivity {

    //boy-kilo girmeye geri gönderiyo
    public void goUpdateValues(){
        Intent intent = new Intent(this, LauncherActivity.class);
        startActivity(intent);
    }
    //su eklemeye gönderiyo
    public void addWaterScreen(){
        Intent intent = new Intent(this, AddWaterPopScreen.class);
        startActivity(intent);
    }
    public void showHealthScreen(){
        Intent intent = new Intent(this, HealthStats.class);
        startActivity(intent);
    }
    public void setReminderScreen(){
        Intent intent = new Intent(this, ReminderScreen.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        //yukardaki metodları çalıştıracak butonlara girdim.
        Button updater;
        Button waterAdder;
        Button degerekran;
        Button setReminder;

        DbViewModel dbViewModel=new DbViewModel(this.getApplication());
        ImageView gender=findViewById(R.id.imageView13); //imageview13 -> gender view
        dbViewModel.getLastRecord().observe(this,response->{

            if(response.gender==0){
                gender.setBackgroundResource(R.drawable.man);
            }else if(response.gender==1){
                gender.setBackgroundResource(R.drawable.woman);
            }else{
                Toast.makeText(this,"Cinsiyet belirtilmedi!",Toast.LENGTH_LONG).show();
            }
        });



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

        degerekran = findViewById(R.id.degers);
        degerekran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHealthScreen();
            }
        });

        setReminder = findViewById(R.id.reminder);
        setReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReminderScreen();
            }
        });
    }
}