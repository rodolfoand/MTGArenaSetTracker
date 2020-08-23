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

    public SetViewModel (Application application) {
        super(application);
        mRepository = new SetRepository(application);
        mMySets = mRepository.getMySets();
    }

    public LiveData<List<Set>> getMySets() { return mMySets; }

    public LiveData<List<Set>> getSets() { return mRepository.getSets(); }

    public LiveData<Set> getSets(String code) { return mRepository.getSets(code); }

    public LiveData<Integer> getRarity(String code, String rarity) { return mRepository.getRarity(code, rarity); }

    public void insert(Set set) { mRepository.insert(set); }

    public void updateCommon(String code, int rarity){
        mRepository.updateCommon(code, rarity);
    }

    public void updateUncommon(String code, int rarity){
        mRepository.updateUncommon(code, rarity);
    }

    public void updateRare(String code, int rarity){
        mRepository.updateRare(code, rarity);
    }

    public void updateMythic(String code, int rarity){
        mRepository.updateMythic(code, rarity);
    }
}