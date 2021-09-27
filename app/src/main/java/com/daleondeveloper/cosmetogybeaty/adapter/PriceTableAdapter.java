package com.daleondeveloper.cosmetogybeaty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daleondeveloper.cosmetogybeaty.DB.Entity.Procedure;
import com.daleondeveloper.cosmetogybeaty.R;

import java.util.List;

public class PriceTableAdapter extends RecyclerView.Adapter<PriceTableAdapter.ProcedureViewHolder> {

    private Context context;
    private List<Procedure> procedures;

    public PriceTableAdapter(Context context, List<Procedure> procedures) {
        this.context = context;
        this.procedures = procedures;
    }

    @NonNull
    @Override
    public ProcedureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItem = LayoutInflater.from(context).inflate(R.layout.element_cost_table_line,parent,false);
        return  new ProcedureViewHolder(courseItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ProcedureViewHolder holder, int position) {
       // holder.courseBg.setBackgroundColor(Color.parseColor(procedures.get(position).getColor()));
        holder.nameTxt.setText(procedures.get(position).getName());
        holder.durationTxt.setText(procedures.get(position).getDuration() + " хвилин");
        holder.costTxt.setText(procedures.get(position).getCost() + " грн");
    }

    @Override
    public int getItemCount() {
        return procedures.size();
    }

    public static final class ProcedureViewHolder extends  RecyclerView.ViewHolder{

        TextView nameTxt,durationTxt,costTxt;


        public ProcedureViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTxt = itemView.findViewById(R.id.procedure_name_price_table);
            durationTxt = itemView.findViewById(R.id.procedure_duration_price_table);
            costTxt = itemView.findViewById(R.id.procedure_cost_price_table);

        }
    }
}
