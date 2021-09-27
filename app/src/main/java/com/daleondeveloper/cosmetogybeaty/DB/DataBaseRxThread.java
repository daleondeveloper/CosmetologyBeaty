package com.daleondeveloper.cosmetogybeaty.DB;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daleondeveloper.cosmetogybeaty.DB.Entity.Procedure;
import com.daleondeveloper.cosmetogybeaty.R;
import com.daleondeveloper.cosmetogybeaty.adapter.ProcedureAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DataBaseRxThread {

   private final CosmetologyDataBase dataBase;

    public DataBaseRxThread(CosmetologyDataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void insertStartElements(){
        List<Procedure> procedures = new ArrayList<>();
        procedures.add(new Procedure("Біоревіталізація",
                "В основе метода — доставка в кожу биосовместимого с \nорганизмом препарата, который обладает не только накопительным эффектом, \n но и запускает механизм обновления. Основной компонент\n инъекционного коктейля — гиалуроновая кислота. Это межклеточное\n вещество — полисахарид, которое присутствует в тканях человека. ",
                R.drawable.biorevitalizatiya,1500,60,true
        ));
        procedures.add(new Procedure("Мезотерапія лиця",
                "Купероз – достаточно распространенное как среди женщин,\n так и мужчин, сосудистое нарушение. В дерматологии купероз принято называть \nтелеангиэктазиями. Внешне он проявляется выраженным сосудистым рисунком \nна коже лица (более заметная локализация).",
                R.drawable.mezoteraphy,2000,30,true
        ));
        procedures.add(new Procedure("Пілінг",
                "Пілінг – косметологічна процедура,\\n що передбачає видалення верхніх ороговілих \\nшарів шкіри і активацію процесів активної регенерації \\nклітин. Слово «пілінг» походить від англійського \\nдієслова to peel «зчищати», «знімати», що точно описує механізми впливу \\nпроцедури.\",\n",
                R.drawable.piling_avatar,400,90,true
        ));
        dataBase.procedureDao().insertAll(procedures).subscribeOn(Schedulers.io()).subscribe(new Action() {
            @Override
            public void run() throws Exception {
                // success
            }
        }, new Consumer< Throwable >() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                // error
            }
        });
    }
    public void setCardViewProcedures(final Activity activity, final int recycleView){
        dataBase.procedureDao().getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Procedure>>() {
                    @Override
                    public void accept(List<Procedure> procedures) throws Exception {
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false);
                        RecyclerView courseRecycle ;
                        ProcedureAdapter procedureAdapter;
                        courseRecycle   = activity.findViewById(recycleView);
                        courseRecycle.setLayoutManager(layoutManager);

                        procedureAdapter = new ProcedureAdapter(activity,procedures);
                        courseRecycle.setAdapter(procedureAdapter);
                    }
                });


    }
}