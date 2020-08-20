package com.rodolfo.mtgarenasettracker.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.rodolfo.mtgarenasettracker.model.Set;

import java.util.List;

public class SetRepository {
    private SetDao mSetDao;
    private LiveData<List<Set>> mAllSets;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    SetRepository(Application application) {
        SetRoomDatabase db = SetRoomDatabase.getDatabase(application);
        mSetDao = db.setDao();
        mAllSets = mSetDao.getAll();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Set>> getAllSets() {
        return mAllSets;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Set set) {
        SetRoomDatabase.databaseWriteExecutor.execute(() -> {
            mSetDao.insert(set);
        });
    }
}
