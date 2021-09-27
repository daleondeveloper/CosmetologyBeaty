package com.daleondeveloper.cosmetogybeaty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.daleondeveloper.cosmetogybeaty.DB.CosmetologyDataBase;
import com.daleondeveloper.cosmetogybeaty.DB.DataBaseRxThread;
import com.daleondeveloper.cosmetogybeaty.DB.Entity.Procedure;
import com.daleondeveloper.cosmetogybeaty.adapter.ProcedureAdapter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class ProcedureActivity extends AppCompatActivity {

    private DataBaseRxThread dataBaseRxThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedure);
        dataBaseRxThread = new DataBaseRxThread(CosmetologyDataBase.getInstance(this));
        dataBaseRxThread.setCardViewProcedures(this,R.id.all_procedure_recycle_view);

    }
}