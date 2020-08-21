package com.rodolfo.mtgarenasettracker.room;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rodolfo.mtgarenasettracker.model.Set;
import com.rodolfo.mtgarenasettracker.rest.Get;

import java.util.List;

public class SetViewModel extends AndroidViewModel {

    private SetRepository mRepository;
    private LiveData<List<Set>> mAllSets;
    private Get mGet;

    public SetViewModel (Application application) {
        super(application);
        mRepository = new SetRepository(application);
        mAllSets = mRepository.getAllSets();
        mGet = new Get(application);
    }

    public LiveData<List<Set>> getMySets() { return mAllSets; }

    public LiveData<List<Set>> getHttpSets(String code) { return mGet.getSets(code); }

    public void insert(Set set) { mRepository.insert(set); }
}