
package com.example.tektek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tektek.database.UserTable;
import com.example.tektek.utils.TiviTypeConverters;
import com.example.tektek.viewmodel.DbViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class GraphicActivity extends AppCompatActivity {

//INTENT ILE MAINACTIVITYDEN GONDER
    LineChart lineChart;
    ArrayList<String> dates;
    //List<UserTable> userTables;
    ArrayList<Integer> userWeights;
    List<Entry> entries;
    DbViewModel dbViewModel;
    LineDataSet lineDataSet;
    LineData lineData;
    //TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);
        //dates=new ArrayList<>();
        //userTables=new ArrayList<>();
        entries=new ArrayList<>();
        dbViewModel=new DbViewModel(getApplication());
        Intent i=getIntent();
        dates= i.getStringArrayListExtra("dates");
        userWeights= i.getIntegerArrayListExtra("weight");

        lineChart=findViewById(R.id.lineChart);
        //textView=findViewById(R.id.deneme);

        for (int iv=0;iv<userWeights.size();iv++) {
            //   textView.append(TiviTypeConverters.toOffsetDateTime(dates.get(iv)).getDayOfMonth()
            //         +String.valueOf(userWeights.get(iv))); //this gives error sometime

            entries.add(new Entry(TiviTypeConverters.toOffsetDateTime(dates.get(iv)).getDayOfMonth(),userWeights.get(iv)));

        }
     /*   dbViewModel.getLastSevenRecordsDate().observe(this,responses->{
            if (responses == null) {
                Toast.makeText(this,"boş geldi",Toast.LENGTH_SHORT).show();
            }else{
                dates=responses;
            }
        });

        dbViewModel.getLastSevenRecords().observe(this,responses->{
            if (responses == null) {
                Toast.makeText(this,"boş 2 geldi",Toast.LENGTH_SHORT).show();
            }else {
                userTables=responses;
                for (int i=0;i<userTables.size();i++) {
                    textView.append(TiviTypeConverters.toOffsetDateTime(dates.get(i)).getDayOfMonth()
                            +String.valueOf(userTables.get(i).weight)); //this gives error sometime

                    entries.add(new Entry(TiviTypeConverters.toOffsetDateTime(dates.get(i)).getDayOfMonth(),userTables.get(i).weight));

                }
            }
        });*/



            lineDataSet=new LineDataSet(entries,"Weight");
            lineDataSet.setColor(Color.MAGENTA);
            lineDataSet.setValueTextColor(Color.DKGRAY);
            Description description=new Description();
            description.setText("Time");
            lineChart.setDescription(description);
            lineData = new LineData(lineDataSet);
            lineChart.setData(lineData);

            lineChart.animateY(800);
            lineChart.invalidate();
            lineDataSet.notifyDataSetChanged();


    }

}