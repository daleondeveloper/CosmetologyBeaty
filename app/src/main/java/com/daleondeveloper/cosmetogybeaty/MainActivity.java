package com.daleondeveloper.cosmetogybeaty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.daleondeveloper.cosmetogybeaty.DB.CosmetologyDataBase;
import com.daleondeveloper.cosmetogybeaty.DB.DAO.ProcedureDao;
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
    RecyclerView  courseRecycle;
    ProcedureAdapter procedureAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Procedure procedure1 =  new Procedure("Пілінг",
                "Пілінг – косметологічна процедура,\\n що передбачає видалення верхніх ороговілих \\nшарів шкіри і активацію процесів активної регенерації \\nклітин. Слово «пілінг» походить від англійського \\nдієслова to peel «зчищати», «знімати», що точно описує механізми впливу \\nпроцедури.\",\n",
                R.drawable.piling_avatar,400,90,true
        );
        Procedure procedure2 =  new Procedure("Мезотерапія лиця",
                "Купероз – достаточно распространенное как среди женщин,\n так и мужчин, сосудистое нарушение. В дерматологии купероз принято называть \nтелеангиэктазиями. Внешне он проявляется выраженным сосудистым рисунком \nна коже лица (более заметная локализация).",
                R.drawable.mezoteraphy,2000,30,true
        );
        Procedure procedure3 =  new Procedure("Біоревіталізація",
                "В основе метода — доставка в кожу биосовместимого с \nорганизмом препарата, который обладает не только накопительным эффектом, \n но и запускает механизм обновления. Основной компонент\n инъекционного коктейля — гиалуроновая кислота. Это межклеточное\n вещество — полисахарид, которое присутствует в тканях человека. ",
                R.drawable.biorevitalizatiya,1500,60,true
        );

        final CosmetologyDataBase dataBase =  CosmetologyDataBase.getInstance(this);
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
        }, new Consumer < Throwable > () {
            @Override
            public void accept(Throwable throwable) throws Exception {
                // error
            }
        });

        dataBase.procedureDao().getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Procedure>>() {
                    @Override
                    public void accept(List<Procedure> procedures) throws Exception {
                       setCourseRecycle(procedures);
                    }
                });

    }

    private void setCourseRecycle(List<Procedure> courses) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        courseRecycle   = findViewById(R.id.courseRecycle);
        courseRecycle.setLayoutManager(layoutManager);

        procedureAdapter = new ProcedureAdapter(this,courses);
        courseRecycle.setAdapter(procedureAdapter);
    }
}