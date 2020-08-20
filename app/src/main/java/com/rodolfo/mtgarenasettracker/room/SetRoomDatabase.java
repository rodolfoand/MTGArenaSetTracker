package com.rodolfo.mtgarenasettracker.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.rodolfo.mtgarenasettracker.model.Set;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Set.class}, version = 1, exportSchema = false)
public abstract class SetRoomDatabase extends RoomDatabase {

    public abstract SetDao setDao();

    private static volatile SetRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static SetRoomDatabase getDatabase(final Context context) {
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
