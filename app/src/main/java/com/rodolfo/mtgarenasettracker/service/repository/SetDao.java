package com.rodolfo.mtgarenasettracker.service.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.rodolfo.mtgarenasettracker.model.Set;

import java.util.List;

@Dao
public interface SetDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Set set);

    @Query("DELETE FROM set_table")
    void deleteAll();

    @Query("SELECT * FROM set_table")
    LiveData<List<Set>> getMySets();
//
//    @Query("SELECT * FROM set_table WHERE id IN (:setIds)")
//    List<Set> loadAllByIds(int[] setIds);
//
//    @Query("SELECT * FROM setentity WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    SetEntity findByName(String first, String last);
//
//    @Insert
//    void insertAll(Set... sets);
//
//    @Delete
//    void delete(Set sets);

    @Query("UPDATE set_table SET common=:rarity WHERE code = :code")
    void updateCommon(String code, int rarity);

    @Query("UPDATE set_table SET uncommon=:rarity WHERE code = :code")
    void updateUncommon(String code, int rarity);

    @Query("UPDATE set_table SET rare=:rarity WHERE code = :code")
    void updateRare(String code, int rarity);

    @Query("UPDATE set_table SET mythic=:rarity WHERE code = :code")
    void updateMythic(String code, int rarity);
}
