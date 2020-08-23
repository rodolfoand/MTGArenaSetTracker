package com.rodolfo.mtgarenasettracker.service;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.rodolfo.mtgarenasettracker.model.Set;
import com.rodolfo.mtgarenasettracker.service.repository.SetDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Set.class}, version = 1, exportSchema = false)
public abstract class SetRoomDatabase extends RoomDatabase {

    public abstract SetDao setDao();

    private static volatile SetRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static SetRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SetRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SetRoomDatabase.class, "set_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
