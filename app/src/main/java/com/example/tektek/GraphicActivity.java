
package com.example.tektek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tektek.adapter.GraphicAdapter;
import com.example.tektek.database.UserTable;
import com.example.tektek.utils.TiviTypeConverters;
import com.example.tektek.viewmodel.DbViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphicActivity extends AppCompatActivity {

//INTENT ILE MAINACTIVITYDEN GONDER
    //LineChart lineChart;
    //ArrayList<String> dates;
    //List<UserTable> userTables;
    //ArrayList<Integer> userWeights;
    List<Entry> entries=new ArrayList<>();
    List<Entry> entries2=new ArrayList<>();
    List<LineDataSet> lineDataSets=new ArrayList<>();
    List<LineData> listLineData=new ArrayList<>();
    DbViewModel dbViewModel;
    //LineDataSet lineDataSet;
    //LineData lineData;
    RecyclerView recyclerView;
    GraphicAdapter graphicAdapter;
    //TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);
        recyclerView=findViewById(R.id.recyclerView);
        //dates=new ArrayList<>();
        //userTables=new ArrayList<>();
        //entries=new ArrayList<>();
        Utils.init(getApplicationContext());
        dbViewModel=new DbViewModel(getApplication());
        dbViewModel.getLastSevenRecords().observe(this,responses->{

            for (int iv=0;iv<responses.size();iv++) {
                entries.add(new Entry(responses.get(iv).date.getDayOfMonth(),responses.get(iv).weight));
            }
            for (int iv=0;iv<responses.size();iv++) {
                entries2.add(new Entry((responses.get(iv).date).getDayOfMonth(),responses.get(iv).drunk));
            }
            lineDataSets.add(new LineDataSet(entries,"Weight"));
            lineDataSets.add(new LineDataSet(entries2,"Drunk"));
            lineDataSets.get(0).setColor(Color.MAGENTA);
            lineDataSets.get(1).setColor(Color.RED);
            listLineData.add(new LineData(lineDataSets.get(0)));
            listLineData.add(new LineData(lineDataSets.get(1)));



            graphicAdapter.setLineDataList(listLineData);

            graphicAdapter.notifyDataSetChanged();
        });
       // Intent i=getIntent();
       // dates= i.getStringArrayListExtra("dates");
       // userWeights= i.getIntegerArrayListExtra("weight");

        //lineChart=findViewById(R.id.lineChart);
        //textView=findViewById(R.id.deneme);

       // for (int iv=0;iv<userWeights.size();iv++) {
            //   textView.append(TiviTypeConverters.toOffsetDateTime(dates.get(iv)).getDayOfMonth()
            //         +String.valueOf(userWeights.get(iv))); //this gives error sometime

       //     entries.add(new Entry(TiviTypeConverters.toOffsetDateTime(dates.get(iv)).getDayOfMonth(),userWeights.get(iv)));

     //   }



        /*    lineDataSet=new LineDataSet(entries,"Weight");
            lineDataSet.setColor(Color.MAGENTA);
            lineDataSet.setValueTextColor(Color.DKGRAY);
            Description description=new Description();
            description.setText("Time");
            lineChart.setDescription(description);
            lineData = new LineData(lineDataSet);*/
            //lineChart.setData(lineData);

            //lineChart.animateY(800);
            //lineChart.invalidate();
            //lineDataSet.notifyDataSetChanged();

            initRecyclerView();
    }

    private void initRecyclerView() {
        if(graphicAdapter==null){
            graphicAdapter=new GraphicAdapter(GraphicActivity.this);
            graphicAdapter.setLineDataList(listLineData);//for nullablity at beginning
            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(graphicAdapter);
        }else{
            graphicAdapter.notifyDataSetChanged();
        }
    }

}