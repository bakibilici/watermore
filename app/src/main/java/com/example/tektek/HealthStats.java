package com.example.tektek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthStats extends AppCompatActivity {

    public void turnMainScreen(){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthstats);

        Button geri =(Button) findViewById(R.id.back);
        ImageView ana = findViewById(R.id.anaresim);
        ImageView i1 = findViewById(R.id.i1);
        ImageView i2 = findViewById(R.id.i2);
        ImageView i3 = findViewById(R.id.i3);
        ImageView i4 = findViewById(R.id.i4);
        ImageView i5 = findViewById(R.id.i5);
        ImageView i6 = findViewById(R.id.i6);
        ImageView i7 = findViewById(R.id.i7);
        ImageView baslikres = findViewById(R.id.imageView7);
        ImageView degerarka = findViewById(R.id.degerarka);
        TextView t1 = findViewById(R.id.baslik);
        TextView t2 = findViewById(R.id.vki);
        TextView t3 = findViewById(R.id.ik);
        TextView t4 = findViewById(R.id.vkm);
        TextView t5 = findViewById(R.id.bmh);
        TextView t6 = findViewById(R.id.gpi);
        TextView t7 = findViewById(R.id.gsi);
        TextView t8 = findViewById(R.id.gyi);
        TextView d1 = findViewById(R.id.deger1);
        TextView d2 = findViewById(R.id.deger2);
        TextView d3 = findViewById(R.id.deger3);
        TextView d4 = findViewById(R.id.deger4);
        TextView d5 = findViewById(R.id.deger5);
        TextView d6 = findViewById(R.id.deger6);
        TextView d7 = findViewById(R.id.deger7);
        Animation animation1 = AnimationUtils.loadAnimation(HealthStats.this,R.anim.fadein);
        Animation animation2 = AnimationUtils.loadAnimation(HealthStats.this,R.anim.lefttoright);
        Animation animation3 = AnimationUtils.loadAnimation(HealthStats.this,R.anim.bounce);
        ana.startAnimation(animation1);
        degerarka.startAnimation(animation1);
        baslikres.startAnimation(animation1);
        t1.startAnimation(animation1);
        t2.startAnimation(animation2);
        t3.startAnimation(animation2);
        t4.startAnimation(animation2);
        t5.startAnimation(animation2);
        t6.startAnimation(animation2);
        t7.startAnimation(animation2);
        t8.startAnimation(animation2);
        d1.startAnimation(animation1);
        d2.startAnimation(animation1);
        d3.startAnimation(animation1);
        d4.startAnimation(animation1);
        d5.startAnimation(animation1);
        d6.startAnimation(animation1);
        d7.startAnimation(animation1);
        i1.startAnimation(animation3);
        i2.startAnimation(animation3);
        i3.startAnimation(animation3);
        i4.startAnimation(animation3);
        i5.startAnimation(animation3);
        i6.startAnimation(animation3);
        i7.startAnimation(animation3);
        geri.startAnimation(animation1);
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnMainScreen();
            }
        });
    }
}