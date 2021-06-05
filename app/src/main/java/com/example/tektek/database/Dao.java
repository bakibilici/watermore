package com.example.tektek.database;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.threeten.bp.OffsetDateTime;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Query("SELECT * FROM UserTable")
    LiveData<List<UserTable>> getAllRecords();

    @Query("SELECT date FROM UserTable ORDER BY date DESC LIMIT 1")
    LiveData<String> getLastDate(); //i think this gets all dates

    @Query("SELECT * FROM UserTable ORDER BY date DESC LIMIT 1")
    LiveData<UserTable> getLastRecord();
//SELECT * FROM UserTable WHERE date=(SELECT MAX(date) FROM UserTable)

    @Query("SELECT * FROM UserTable ORDER BY date DESC LIMIT 8") //for graphics
    LiveData<List<UserTable>> getLastSevenRecord();

    @Query("SELECT date FROM UserTable ORDER BY date DESC LIMIT 8") //for graphics
    LiveData<List<String>> getLastSevenRecordDate();

    @Query("UPDATE UserTable SET drunk = :drunk + drunk WHERE recordId=(SELECT Max(recordId) FROM UserTable)")
    void update(int drunk);

    //@Query("UPDATE UserTable SET drunk = :drunk+drunk WHERE date=(SELECT date FROM UserTable ORDER BY date DESC LIMIT 1)")
    //@Update//i think it needs UserTable as parameter

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOne(UserTable userTable);
}
