package com.daleondeveloper.cosmetogybeaty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.daleondeveloper.cosmetogybeaty.DB.CosmetologyDataBase;
import com.daleondeveloper.cosmetogybeaty.DB.DAO.ProcedureDao;
import com.daleondeveloper.cosmetogybeaty.DB.DataBaseRxThread;
import com.daleondeveloper.cosmetogybeaty.DB.Entity.Procedure;
import com.daleondeveloper.cosmetogybeaty.adapter.ProcedureAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    final String[] menuNames = new  String[]{
        "Головна",
            "Підбір\nПроцедури",
            "Процедури",
            "Контакти"
    };
    private DataBaseRxThread dataBaseRxThread;
    RecyclerView  courseRecycle;
    ProcedureAdapter procedureAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        dataBaseRxThread = new DataBaseRxThread(CosmetologyDataBase.getInstance(this));
//        dataBaseRxThread.insertStartElements();
//        dataBaseRxThread.setCardViewProcedures(this,R.id.courseRecycle);

    }
}