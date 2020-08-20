package com.rodolfo.mtgarenasettracker.room;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rodolfo.mtgarenasettracker.model.Set;

import java.util.List;

public class SetViewModel extends AndroidViewModel {

    private SetRepository mRepository;

    private LiveData<List<Set>> mAllSets;

    public SetViewModel (Application application) {
        super(application);
        mRepository = new SetRepository(application);
        mAllSets = mRepository.getAllSets();
    }

    LiveData<List<Set>> getAllSets() { return mAllSets; }

    public void insert(Set set) { mRepository.insert(set); }
}