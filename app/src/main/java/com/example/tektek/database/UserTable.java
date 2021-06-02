package com.example.tektek.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.tektek.utils.TiviTypeConverters;

import org.threeten.bp.OffsetDateTime;

@Entity
public class UserTable {
   @PrimaryKey(autoGenerate = true)
    public int recordId;

   // @ColumnInfo(name= "user_name")
   // public String username;

    @ColumnInfo(name= "height")
    public int height;

    @ColumnInfo(name= "weight")
    public int weight;

    @ColumnInfo(name= "age")
    public int age;

    @ColumnInfo(name= "gender")
    public int gender;

    @ColumnInfo(name= "dailyActivity")
    public int dailyActivity;

    @ColumnInfo(name= "temperature")
    public int temperature;

    @TypeConverters(TiviTypeConverters.class)
    @ColumnInfo(name = "date")
    OffsetDateTime date;



}