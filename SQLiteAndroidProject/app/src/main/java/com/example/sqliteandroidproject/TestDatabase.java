package com.example.sqliteandroidproject;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class}, version = 1)
public abstract class TestDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();

    private static volatile TestDatabase INSTANCE;

    public static TestDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TestDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    TestDatabase.class, "test_database")
                            .fallbackToDestructiveMigration() // Optional migration strategy
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

