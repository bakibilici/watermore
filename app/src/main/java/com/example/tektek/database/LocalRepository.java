package com.example.tektek.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import org.threeten.bp.OffsetDateTime;

import java.util.List;

public class LocalRepository {

    private Dao dao;
    private LiveData<List<UserTable>> allRecords;
    private LiveData<UserTable> oneLastRecord;
    public LocalRepository(Application application){
        AppDatabase db= AppDatabase.getDatabase(application);
        dao=db.Dao();
    }
    public LiveData<List<UserTable>> getAllRecords(){
        allRecords =dao.getAllRecords();
        return allRecords;
    }
    public void insertData(UserTable userTable){
    AppDatabase.databaseWriteExecutor.execute(()->{
        userTable.date= OffsetDateTime.now();
        dao.insertOne(userTable);
    });
    }

    public LiveData<List<UserTable>> getAllRecordsByDate(){
        allRecords =dao.getAllRecordsByDate();
        return allRecords;
    }


    public LiveData<UserTable> getLastRecord(){
        oneLastRecord= dao.getLastRecord();
        return oneLastRecord;
    }

}
