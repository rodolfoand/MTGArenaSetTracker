package com.rodolfo.mtgarenasettracker.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rodolfo.mtgarenasettracker.model.Set;
import com.rodolfo.mtgarenasettracker.service.repository.SetRepository;

import java.util.List;

public class SetViewModel extends AndroidViewModel {

    private SetRepository mRepository;
    private LiveData<List<Set>> mMySets;
    private LiveData<List<Set>> mAllSets;

    public SetViewModel (Application application) {
        super(application);
        mRepository = new SetRepository(application);
        mMySets = mRepository.getMySets();
        mAllSets = mRepository.getHttpSets();
    }

    public LiveData<List<Set>> getMySets() { return mMySets; }

    public LiveData<List<Set>> getHttpSet() { return mAllSets; }


    public LiveData<Set> getHttpSet(String code) { return mRepository.getHttpSets(code); }

    public void insert(Set set) { mRepository.insert(set); }
}