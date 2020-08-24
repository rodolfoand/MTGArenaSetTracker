package com.rodolfo.mtgarenasettracker.service.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.rodolfo.mtgarenasettracker.model.Card;
import com.rodolfo.mtgarenasettracker.model.Set;

import java.util.List;

@Dao
public interface CardDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Card card);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCards(Card... cards);

    @Query("DELETE FROM card_table")
    void deleteAll();

    @Query("SELECT * FROM card_table")
    LiveData<List<Card>> getMyCards();

    @Delete
    void delete(Card card);

}
