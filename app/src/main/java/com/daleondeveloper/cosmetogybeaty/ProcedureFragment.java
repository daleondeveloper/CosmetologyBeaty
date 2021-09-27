package com.daleondeveloper.cosmetogybeaty;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class ProcedureFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_procedure,container,false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.procedure_recycle_view);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        CardView cardView = (CardView)view.findViewById(R.id.card);
    //    Button button = new Button(getContext());
       // ArrayAdapter<View> viewArrayAdapter = new ArrayAdapter<View>(getContext(),
                //)
//        recyclerView.addView(cardView);
        recyclerView.setLayoutManager(layoutManager);
        return inflater.inflate(R.layout.fragment_procedure, container, false);
    }
}