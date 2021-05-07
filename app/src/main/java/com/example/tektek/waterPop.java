package com.example.tektek;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class waterPop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_pop);
        //burası popup ölçü
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.7));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x=0;
        params.y=-20;
        //her içilen mL için 3 eleman var onları danımladım
        getWindow().setAttributes(params);
        ImageView tea = findViewById(R.id.tea);
        ImageView tearec = findViewById(R.id.tearec);
        ImageView teaolcu = findViewById(R.id.teaolcu);
        ImageView glass = findViewById(R.id.glass);
        ImageView glassrec = findViewById(R.id.glassrec);
        ImageView glassolcu = findViewById(R.id.glassolcu);
        ImageView cup = findViewById(R.id.cupimage);
        ImageView cuprec = findViewById(R.id.cuprec);
        ImageView cupolcu = findViewById(R.id.cupolcu);
        ImageView pcup = findViewById(R.id.karton);
        ImageView pcuprec = findViewById(R.id.kartonrec);
        ImageView pcupolcu = findViewById(R.id.papercupolcu);
        ImageView bottle = findViewById(R.id.sise);
        ImageView bottlerec = findViewById(R.id.siserec);
        ImageView bottleolcu = findViewById(R.id.bottleolcu);
        ImageView surahi = findViewById(R.id.surahi);
        ImageView surahirec = findViewById(R.id.surahirec);
        ImageView surahiolcu =findViewById(R.id.surahiolcu);
        ImageView musluk = findViewById(R.id.musluk);
        ImageView muslukrec = findViewById(R.id.muslukrec);
        ImageView binustu = findViewById(R.id.binustu);
        ImageView verigir = findViewById(R.id.binustugir);
        verigir.setVisibility(View.INVISIBLE);
        //onclicklerle resimler güzelleşiyo felan yane
        tearec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tearec.setImageResource(R.drawable.addwaterselectedblue);
                tea.setImageResource(R.drawable.teaafter);
                teaolcu.setImageResource(R.drawable.teaolcuafter);
            }
        });
        glassrec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glass.setImageResource(R.drawable.glassafter);
                glassrec.setImageResource(R.drawable.addwaterselectedred);
                glassolcu.setImageResource(R.drawable.glassolcuafter);
            }
        });
        cuprec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cup.setImageResource(R.drawable.cupafter);
                cuprec.setImageResource(R.drawable.addwaterselectedblue);
                cupolcu.setImageResource(R.drawable.cupolcuafter);
            }
        });
        pcuprec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pcup.setImageResource(R.drawable.papercupafter);
                pcuprec.setImageResource(R.drawable.addwaterselectedred);
                pcupolcu.setImageResource(R.drawable.paperolcuafter);
            }
        });
        bottlerec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottle.setImageResource(R.drawable.bottleafter);
                bottlerec.setImageResource(R.drawable.addwaterselectedblue);
                bottleolcu.setImageResource(R.drawable.bottleolcuafter);
            }
        });
        surahirec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                surahi.setImageResource(R.drawable.surahiafter);
                surahirec.setImageResource(R.drawable.addwaterselectedred);
                surahiolcu.setImageResource(R.drawable.surahiolcuafter);
            }
        });
        musluk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musluk.setImageResource(R.drawable.muslukafter);
                muslukrec.setImageResource(R.drawable.addwaterselectedblue);
                binustu.setImageResource(R.drawable.binustuafter);
            }
        });
    }
}