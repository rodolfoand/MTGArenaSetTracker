package com.rodolfo.mtgarenasettracker.service.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.rodolfo.mtgarenasettracker.model.Set;
import com.rodolfo.mtgarenasettracker.service.Scryfall;
import com.rodolfo.mtgarenasettracker.service.SetRoomDatabase;

import java.util.List;

public class SetRepository {
    private SetDao mSetDao;
    private LiveData<List<Set>> mMySets;
    private LiveData<List<Set>> mAllSets;
    private Scryfall mScryfall;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public SetRepository(Application application) {
        SetRoomDatabase db = SetRoomDatabase.getDatabase(application);
        mSetDao = db.setDao();
        mMySets = mSetDao.getMySets();
        mScryfall = new Scryfall(application);
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Set>> getMySets() {
        return mMySets;
    }



//    LiveData<List<Set>> getHttpSets() {
//        return mAllSets;
//    }
    public LiveData<List<Set>> getHttpSets() {
        return mScryfall.getSet();
    }
    public LiveData<Set> getHttpSets(String code) {
        return mScryfall.getSet(code);
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Set set) {
        SetRoomDatabase.databaseWriteExecutor.execute(() -> {
            mSetDao.insert(set);
        });
    }
}
