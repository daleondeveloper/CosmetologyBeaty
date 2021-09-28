package com.daleondeveloper.cosmetogybeaty.DB;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daleondeveloper.cosmetogybeaty.DB.Entity.Procedure;
import com.daleondeveloper.cosmetogybeaty.MakeAppointmentActivity;
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
                "В основе метода — доставка в кожу биосовместимого с организмом препарата, который обладает не только накопительным эффектом, но и запускает механизм обновления. Основной компонент инъекционного коктейля — гиалуроновая кислота. Это межклеточное вещество — полисахарид, которое присутствует в тканях человека. ",
                R.drawable.biorevitalizatiya,1500,60,true
        ));
        procedures.add(new Procedure("Мезотерапія лиця",
                "Купероз – достаточно распространенное как среди женщин, так и мужчин, сосудистое нарушение. В дерматологии купероз принято называть телеангиэктазиями. Внешне он проявляется выраженным сосудистым рисунком на коже лица (более заметная локализация).",
                R.drawable.mezoteraphy,2000,30,true
        ));
        procedures.add(new Procedure("Пілінг",
                "Пілінг – косметологічна процедура, що передбачає видалення верхніх ороговілих шарів шкіри і активацію процесів активної регенерації клітин. Слово «пілінг» походить від англійського дієслова to peel «зчищати», «знімати», що точно описує механізми впливу процедури.\",",
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
    public void setSpinnerMakeAppointment(final Activity activity, final int spinnerId){
        dataBase.procedureDao().getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Procedure>>() {
                    @Override
                    public void accept(List<Procedure> procedures) throws Exception {
                        Spinner spinner = (Spinner)activity.findViewById(spinnerId);
                        List<String> s = new ArrayList<>();
                        for(Procedure procedure : procedures){
                            s.add(procedure.getName());
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,  android.R.layout.simple_spinner_item, s);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);
                    }
                });
    }
    public void setMakeAppointmentCostAndDuration(final MakeAppointmentActivity activity, final String procedureName){
        dataBase.procedureDao().getProcedureByName(procedureName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Procedure>() {
                    @Override
                    public void accept(Procedure procedure) throws Exception {
                        activity.setOnTextView(procedure.getCost(),procedure.getDuration());
                    }
                });
    }
}
