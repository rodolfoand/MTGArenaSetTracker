package com.rodolfo.mtgarenasettracker.service.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.rodolfo.mtgarenasettracker.model.Set;
import com.rodolfo.mtgarenasettracker.service.Scryfall;
import com.rodolfo.mtgarenasettracker.service.SetRoomDatabase;

import java.util.List;

public class SetRepository {
    private SetDao mSetDao;
    private LiveData<List<Set>> mMySets;
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

    public LiveData<List<Set>> getSets() {
        return mScryfall.getSets();
    }
    public LiveData<Set> getSets(String code) {
        return mScryfall.getSets(code);
    }

    public LiveData<Integer> getRarity(String set, String rarity){
        return mScryfall.getRarity(set, rarity);
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Set set) {
        SetRoomDatabase.databaseWriteExecutor.execute(() -> {
            mSetDao.insert(set);
        });
    }

    public void updateCommon (String code, int rarity){
        SetRoomDatabase.databaseWriteExecutor.execute(() ->{
            mSetDao.updateCommon(code, rarity);
        });
    }

    public void updateUncommon (String code, int rarity){
        SetRoomDatabase.databaseWriteExecutor.execute(() ->{
            mSetDao.updateUncommon(code, rarity);
        });
    }

    public void updateRare (String code, int rarity){
        SetRoomDatabase.databaseWriteExecutor.execute(() ->{
            mSetDao.updateRare(code, rarity);
        });
    }

    public void updateMythic (String code, int rarity){
        SetRoomDatabase.databaseWriteExecutor.execute(() ->{
            mSetDao.updateMythic(code, rarity);
        });
    }
}
