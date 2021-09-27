package com.daleondeveloper.cosmetogybeaty.DB.DAO;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.daleondeveloper.cosmetogybeaty.DB.Entity.Procedure;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface ProcedureDao {

    @Query("SELECT * FROM Procedure")
    public Flowable<List<Procedure>> getAll();

    @Query("SELECT * FROM Procedure WHERE isAvailable = :isAvailable")
    public Cursor getAllAvailable(boolean isAvailable);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Completable insertAll(List<Procedure> procedure);
    @Insert
    public void insert(Procedure procedure);

    @Update
    public void update(Procedure procedure);

    @Delete
    public void delete(Procedure procedure);
}
