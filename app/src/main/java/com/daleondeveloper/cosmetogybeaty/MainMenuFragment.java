package com.daleondeveloper.cosmetogybeaty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainMenuFragment extends Fragment {
    final String[] menuNames = new  String[]{
            "Головна",
            "Кабінет",
            "Прайс лист",
            "Процедури",
            "Контакти"
    };

    private Context activityContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activityContext = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_menu,container,false);
        ListView listView = view.findViewById(R.id.main_menu_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activityContext,
                R.layout.element_list_view_main_menu,menuNames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String name = "Button pressed " + position;
                Toast.makeText(activityContext, name, Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0 : {
                        Intent intent = new Intent(activityContext,MainActivity.class);
                        activityContext.startActivity(intent);
                    }
                    break;
                    case 1 : {
                        Intent intent = new Intent(activityContext,UserActitvity.class);
                        activityContext.startActivity(intent);
                    }
                    break;
                    case 2 :{
                        Intent intent = new Intent(activityContext,PriceList.class);
                        activityContext.startActivity(intent);
                    }
                    break;
                    case 3 : {
                        Intent intent = new Intent(activityContext,ProcedureActivity.class);
                        activityContext.startActivity(intent);
                    }
                    break;
                    case 4 : {
                        Intent intent = new Intent(activityContext,ContactActivity.class);
                        activityContext.startActivity(intent);
                    }
                    break;
                }


            }
        });
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activityContext = null;
    }

}