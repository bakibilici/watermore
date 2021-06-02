package com.example.tektek.database;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Query("SELECT * FROM UserTable")
    LiveData<List<UserTable>> getAllRecords();

    @Query("SELECT * FROM UserTable ORDER BY datetime(date)")
    LiveData<List<UserTable>> getAllRecordsByDate();

    @Query("SELECT * FROM UserTable ORDER BY date DESC LIMIT 1")
    LiveData<UserTable> getLastRecord();
//SELECT * FROM UserTable WHERE date=(SELECT MAX(date) FROM UserTable)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOne(UserTable userTable);
}
