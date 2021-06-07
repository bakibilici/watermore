package com.example.tektek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tektek.database.UserTable;
import com.example.tektek.utils.Constants;
import com.example.tektek.viewmodel.DbViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    public void goGraphicScreen(){
        Intent intent=new Intent(this,GraphicActivity.class);
        //if we cant make graphic activity work with viewmodel observe
        // intent.putStringArrayListExtra("dates", dates);
        //intent.putIntegerArrayListExtra("weight",weights);
        startActivity(intent);
    }
    public void setReminderScreen(){
        Intent intent = new Intent(this, ReminderScreen.class);
        startActivity(intent);
    }
    TextView bmiText;
    TextView goalText;
    TextView droppercentage;
    ArrayList<String> dates;
    ArrayList<Integer> weights=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        //yukardaki metodları çalıştıracak butonlara girdim.
        Button updater;
        Button waterAdder;
        Button degerekran;
        Button setReminder;
        Button graphicshowbutton=findViewById(R.id.graphicShowButton);

        bmiText=findViewById(R.id.bmitextmainpage);
        goalText=findViewById(R.id.goalwatertext);
        droppercentage=findViewById(R.id.droppercentage);

        DbViewModel dbViewModel=new DbViewModel(this.getApplication());
        ImageView gender=findViewById(R.id.imageView13); //imageview13 -> gender view
        dbViewModel.getLastRecord().observe(this,response->{
          if(response!=null){
              String trim = String.valueOf(((double) response.drunk/1000)/response.goal);
              int stringsize=trim.length();

              if(stringsize>3){
                  trim=trim.substring(2,4);
              }else if(stringsize==3){
                  trim=trim.substring(2,3);  //KÜÇÜK DEĞERLERDE HALA SORUN VAR %09 GÖRÜNDÜ AQ
              }else{
                  trim=String.valueOf(0);
              }
              if(((double)response.drunk/1000)>response.goal){
                  droppercentage.setText("%100");
              }else{
                  droppercentage.setText("%"+trim);
              }

              bmiText.setText(String.valueOf(response.bmi)+" "+ getResources().getString(R.string.bmishort));
              goalText.setText(String.valueOf(String.format("%.2f", response.goal))+" L");
              if(response.gender== Constants.GENDER_MALE){
                  gender.setBackgroundResource(R.drawable.man);
              }else if(response.gender==Constants.GENDER_FEMALE){
                  gender.setBackgroundResource(R.drawable.woman);
              }else{
                  Toast.makeText(this,"Cinsiyet belirtilmedi!",Toast.LENGTH_LONG).show();
              }
          }

        });

        //if we cant make graphic activity work with viewmodel observe
        /*dbViewModel.getLastSevenRecords().observe(this,response->{
            for (int i=0;i<response.size();i++){
                weights.add(response.get(i).weight);
            }
        });
        dbViewModel.getLastSevenRecordsDate().observe(this,response->{
            dates=(ArrayList<String>) response;
        });*/


        graphicshowbutton.setOnClickListener(view->{
            goGraphicScreen();
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