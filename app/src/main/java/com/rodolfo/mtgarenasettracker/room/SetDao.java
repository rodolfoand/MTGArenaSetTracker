package com.rodolfo.mtgarenasettracker.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.rodolfo.mtgarenasettracker.model.Set;

import java.util.List;

@Dao
public interface SetDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Set set);

    @Query("DELETE FROM set_table")
    void deleteAll();

    @Query("SELECT * FROM set_table")
    LiveData<List<Set>> getAll();
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
}
