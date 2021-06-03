package com.example.tektek.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.tektek.database.LocalRepository;
import com.example.tektek.database.UserTable;

import org.threeten.bp.OffsetDateTime;

import java.util.List;

public class DbViewModel extends ViewModel {
    private static LocalRepository localRepository;
    private LiveData<String> lastDate;
    private LiveData<UserTable> oneTable;

    public DbViewModel(Application application){
        this.localRepository=new LocalRepository(application);
        oneTable= localRepository.getLastRecord();
        lastDate= localRepository.getLastDate();
    }


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
