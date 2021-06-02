package com.example.tektek.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.tektek.database.LocalRepository;
import com.example.tektek.database.UserTable;

import java.util.List;

public class DbViewModel extends ViewModel {
    private static LocalRepository localRepository;
    private LiveData<List<UserTable>> allTables;
    private LiveData<UserTable> oneTable;

    public DbViewModel(Application application){
        this.localRepository=new LocalRepository(application);
    }

    public LiveData<List<UserTable>> getAllRecords(){
        allTables= localRepository.getAllRecords();
        return allTables;
    }
    public LiveData<List<UserTable>> getAllRecordsByDate(){
        allTables= localRepository.getAllRecordsByDate();
        return allTables;
    }

    public LiveData<UserTable> getLastRecord(){
        oneTable= localRepository.getLastRecord();
        return oneTable;
    }

    public void insertOne(UserTable userTable){
        localRepository.insertData(userTable);
    }

}
