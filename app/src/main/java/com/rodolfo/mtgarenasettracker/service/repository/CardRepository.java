package com.rodolfo.mtgarenasettracker.service.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.rodolfo.mtgarenasettracker.model.Card;
import com.rodolfo.mtgarenasettracker.model.Set;
import com.rodolfo.mtgarenasettracker.service.Scryfall;
import com.rodolfo.mtgarenasettracker.service.SetRoomDatabase;

import java.util.List;

public class CardRepository {
    private CardDao mCardDao;
    private LiveData<List<Card>> mMyCards;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public CardRepository(Application application) {
        SetRoomDatabase db = SetRoomDatabase.getDatabase(application);
        mCardDao = db.cardDao();
    }

}
