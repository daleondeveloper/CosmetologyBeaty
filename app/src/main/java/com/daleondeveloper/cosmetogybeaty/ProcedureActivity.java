package com.daleondeveloper.cosmetogybeaty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.daleondeveloper.cosmetogybeaty.DB.CosmetologyDataBase;
import com.daleondeveloper.cosmetogybeaty.DB.Entity.Procedure;
import com.daleondeveloper.cosmetogybeaty.adapter.ProcedureAdapter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class ProcedureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedure);
        CosmetologyDataBase.getInstance(this).procedureDao().getAll()
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

        RecyclerView courseRecycle   = findViewById(R.id.all_procedure_recycle_view);
        courseRecycle.setLayoutManager(layoutManager);

        ProcedureAdapter procedureAdapter = new ProcedureAdapter(this,courses);
        courseRecycle.setAdapter(procedureAdapter);
    }
}