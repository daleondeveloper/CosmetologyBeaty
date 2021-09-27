package com.daleondeveloper.cosmetogybeaty.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.daleondeveloper.cosmetogybeaty.DB.DAO.ProcedureDao;
import com.daleondeveloper.cosmetogybeaty.DB.Entity.Procedure;
import com.daleondeveloper.cosmetogybeaty.R;

@Database(entities = {Procedure.class}, version = CosmetologyDataBase.VERSION)
public abstract class CosmetologyDataBase extends RoomDatabase {

    static final int VERSION = 3;
    private static volatile CosmetologyDataBase instance;

    public abstract ProcedureDao procedureDao();


    public static CosmetologyDataBase getInstance(Context context){
        if(instance == null){
            synchronized (CosmetologyDataBase.class){
                if(instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            CosmetologyDataBase.class, "CosmetologyDatabase").build();
                }
            }
        }
        return instance;
    }


}
