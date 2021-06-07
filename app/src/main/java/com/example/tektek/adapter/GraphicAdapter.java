package com.example.tektek.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tektek.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.LineData;

import java.util.ArrayList;
import java.util.List;

public class GraphicAdapter extends RecyclerView.Adapter<GraphicAdapter.MyViewHolder>{
    private Context context;
    List<LineData> lineDataList;
    public List<Description> descriptions=new ArrayList<>();


    public void setLineDataList(List<LineData> lineDataList) {
        this.lineDataList = lineDataList;
    }



    public GraphicAdapter(Context context){
        this.context=context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.graph_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.lineChart.setData(lineDataList.get(position));
        holder.lineChart.invalidate();
        holder.titleText.setText("Grafikss");
    }

    @Override
    public int getItemCount() {
        return lineDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titleText;
        LineChart lineChart;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText=itemView.findViewById(R.id.graphicTitleText);
            lineChart=itemView.findViewById(R.id.lineChart);
        }
    }
}
