package com.example.tektek.database

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.Executor


@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {
    private lateinit var dao: Dao
    private lateinit var appDatabase: AppDatabase

    @Test
    fun testCase() {

    }

    @After
    fun tearDown() {
        appDatabase.close()
    }

    @Before
    fun setUp() {
        val context=ApplicationProvider.getApplicationContext<Context>()
        appDatabase= Room.inMemoryDatabaseBuilder(context,AppDatabase::class.java).build()
        dao=appDatabase.Dao()
    }
}