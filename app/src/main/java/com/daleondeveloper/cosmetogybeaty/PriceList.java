package com.daleondeveloper.cosmetogybeaty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.daleondeveloper.cosmetogybeaty.DB.CosmetologyDataBase;
import com.daleondeveloper.cosmetogybeaty.DB.Entity.Procedure;
import com.daleondeveloper.cosmetogybeaty.adapter.PriceTableAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class PriceList extends AppCompatActivity {

    private static final String[] procedureces_price = {
      "Чистка обличчя      400 грн      2 години",
      "Чистка обличчя      1000 грн      30 хвилин",
      "Чистка обличчя      200 грн      2 години 30 хвилин",
      "Чистка обличчя      2000 грн      1 години",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_list);
         final RecyclerView listView = findViewById(R.id.price_list_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        //listView   = findViewById(R.id.courseRecycle);
        listView.setLayoutManager(layoutManager);


        ArrayAdapter<String> prices = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, procedureces_price
        );
        CosmetologyDataBase.getInstance(this).procedureDao().getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Procedure>>() {
                    @Override
                    public void accept(List<Procedure> procedures) throws Exception {
                        PriceTableAdapter priceTableAdapter = new PriceTableAdapter(getApplicationContext(),procedures);
                        listView.setAdapter(priceTableAdapter);
                    }
                });
    }
}