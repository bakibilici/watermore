package com.example.tektek.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import org.threeten.bp.OffsetDateTime;

import java.util.List;

public class LocalRepository {

    private Dao dao;
    private LiveData<String> date;
    private LiveData<UserTable> oneLastRecord;
    public LocalRepository(Application application){
        AppDatabase db= AppDatabase.getDatabase(application);
        dao=db.Dao();
    }

    public void insertData(UserTable userTable){
    AppDatabase.databaseWriteExecutor.execute(()->{
        userTable.date= OffsetDateTime.now();
        dao.insertOne(userTable);
    });
    }

    public LiveData<String> getLastDate(){
        date =dao.getLastDate();
        return date;
    }


    public LiveData<UserTable> getLastRecord(){
        oneLastRecord= dao.getLastRecord();
        return oneLastRecord;
    }

    public void update(int drunk){
        AppDatabase.databaseWriteExecutor.execute(()->{
            dao.update(drunk);
        });

    }

}
