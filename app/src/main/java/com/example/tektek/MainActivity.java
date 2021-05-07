package com.example.tektek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;


public class MainActivity extends AppCompatActivity {

    public void goMainScreen(){
        Intent intent = new Intent(this, mainPage.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //spinner atama
        Spinner spinnerkg = findViewById(R.id.spinnerkg);
        Spinner spinnercm = findViewById(R.id.spinnercm);
        Spinner spinneryr = findViewById(R.id.spinneryr);
        Spinner spinnerda = findViewById(R.id.spinnerda);
        Spinner spinnerwa = findViewById(R.id.spinnerwa);
        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageView burger1 = findViewById(R.id.burger);
        ImageView boykare = findViewById(R.id.imageView6);
        ImageView boycu = findViewById(R.id.boycu);
        ImageView yaskare = findViewById(R.id.imageView5);
        ImageView yasci = findViewById(R.id.calendar);
        Button save;


        //spinner veriler
        List<String> dailies = new ArrayList<>();
        dailies.add(0, "Günlük Aktifliğiniz.");
        dailies.add("Hareket etmiyorum, egzersiz yapmıyorum.");
        dailies.add("Çok az hareket ediyorum.");
        dailies.add("Günüm hareketli geçiyor. Hareket ediyorum.");
        dailies.add("Bolca hareket ediyor , egzersiz yapıyorum.");
        dailies.add("Spor yapıyorum , aşırı hareket ediyorum.");
        //spinnera array adapte
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, R.layout.colorspinner, dailies);
        arrayAdapter.setDropDownViewResource(R.layout.colorspinner_dropdown);
        spinnerda.setAdapter(arrayAdapter);
        //laciverti
        List<String> weatheries = new ArrayList<>();
        weatheries.add(0, "Yaşadığınız ortamın genel sıcaklığı.");
        weatheries.add("Çok sıcak.");
        weatheries.add("Normal fakat biraz sıcak.");
        weatheries.add("Normal.");
        weatheries.add("Normal fakat biraz serin.");
        weatheries.add("Çok soğuk.");
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter(this, R.layout.colorspinner, weatheries);
        arrayAdapter2.setDropDownViewResource(R.layout.colorspinner_dropdown);
        spinnerwa.setAdapter(arrayAdapter2);

        //sayıları for dönügüsü ile vercem ondan mütevellit üçünü de int olarak tanımladım aralık için
        int kilo;
        int height;
        int yr;
        //anlamışsındır aralığı spinnera ciri
        List<String> kilos = new ArrayList<>();
        kilos.add("-");
        for(kilo = 27; kilo <= 170; kilo++) {
            String a = String.valueOf(kilo);
            kilos.add(a);
        }
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter(this, R.layout.lilspinners, kilos);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerkg.setAdapter(arrayAdapter3);

        List<String> heights = new ArrayList<>();
        heights.add("-");
        for(height = 125; height <= 210; height++) {
            String a = String.valueOf(height);
            heights.add(a);
        }
        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter(this, R.layout.lilspinners, heights);
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercm.setAdapter(arrayAdapter4);

        List<String> years = new ArrayList<>();
        years.add("-");
        for(yr = 13; yr <= 70; yr++) {
            String a = String.valueOf(yr);
            years.add(a);
        }
        ArrayAdapter<String> arrayAdapter5 = new ArrayAdapter(this, R.layout.lilspinners, years);
        arrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinneryr.setAdapter(arrayAdapter5);
        //spinnerdan veri select edilince değişi
        spinnerkg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0) {
                    imageView3.setImageResource(R.drawable.rectangle2after);
                    burger1.setImageResource(R.drawable.burger2);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnercm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0) {
                    boykare.setImageResource(R.drawable.boyafter);
                    boycu.setImageResource(R.drawable.height1);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinneryr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0) {
                    yaskare.setImageResource(R.drawable.ageafter);
                    yasci.setImageResource(R.drawable.calendar1);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //button animasyonu
        save=(Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.blink_anim);
                save.startAnimation(animation);
                goMainScreen();
            }

        });






    }
}