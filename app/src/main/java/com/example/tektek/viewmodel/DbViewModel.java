package com.example.tektek.viewmodel;

import android.app.Application;
import android.graphics.Color;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.tektek.database.LocalRepository;
import com.example.tektek.database.UserTable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import org.threeten.bp.OffsetDateTime;

import java.util.List;

public class DbViewModel extends ViewModel {
    private static LocalRepository localRepository;
    private LiveData<String> lastDate;
    private LiveData<UserTable> oneTable;
    private LiveData<List<UserTable>> multipleRecords;
    private LiveData<List<String>> multipleRecordsDate;
    private LiveData<List<LineData>> listLineData;

    public DbViewModel(Application application){
        this.localRepository=new LocalRepository(application);
        oneTable= localRepository.getLastRecord();
        lastDate= localRepository.getLastDate();
        multipleRecords=localRepository.getLastSevenRecord();
        multipleRecordsDate=localRepository.getLastSevenRecordDate();

    }

    List<Entry> entries;
    List<Entry> entries2;
    List<LineDataSet> lineDataSets;
    public LiveData<List<UserTable>> getLastSevenRecords(){
        return multipleRecords;
    }
    public LiveData<List<String>> getLastSevenRecordsDate() {
        return multipleRecordsDate;
    }//NOT NEEDED ANYMORE


   /* public LiveData<List<LineData>> getDatesAndRecords(){
        multipleRecords=getLastSevenRecords();
        for (int iv=0;iv<multipleRecords.getValue().size();iv++) {
            entries.add(new Entry(multipleRecords.getValue().get(iv).date.getDayOfMonth(),multipleRecords.getValue().get(iv).weight));
        }
        for (int iv=0;iv<multipleRecords.getValue().size();iv++) {
            entries2.add(new Entry((multipleRecords.getValue().get(iv).date).getDayOfMonth(),multipleRecords.getValue().get(iv).drunk));
        }
        lineDataSets.add(new LineDataSet(entries,"Weight"));
        lineDataSets.add(new LineDataSet(entries2,"Drunk"));
        lineDataSets.get(0).setColor(Color.MAGENTA);
        lineDataSets.get(1).setColor(Color.RED);
        listLineData.getValue().get(0).addDataSet(lineDataSets.get(0));
        listLineData.getValue().get(1).addDataSet(lineDataSets.get(1));
        return listLineData;

    }*/

    public LiveData<String> getLastDate(){
        return lastDate;
    }

    public LiveData<UserTable> getLastRecord(){
        return oneTable;
    }

    public void update(int drunk){
        localRepository.update(drunk);
    }

    public void insertOne(UserTable userTable){
        localRepository.insertData(userTable);
    }

}
