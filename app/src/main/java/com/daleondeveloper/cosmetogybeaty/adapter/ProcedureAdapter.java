package com.daleondeveloper.cosmetogybeaty.adapter;

import android.content.Context;
import android.graphics.Color;
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

import java.util.ArrayList;
import java.util.List;

public class ProcedureAdapter extends RecyclerView.Adapter<ProcedureAdapter.ProcedureViewHolder> {

    private Context context;
    private List<Procedure> procedures;

    public ProcedureAdapter(Context context, List<Procedure> procedures) {
        this.context = context;
        this.procedures = procedures;
    }

    @NonNull
    @Override
    public ProcedureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItem = LayoutInflater.from(context).inflate(R.layout.course_item,parent,false);
        return  new ProcedureViewHolder(courseItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ProcedureViewHolder holder, int position) {

      //  holder.courseBg.setBackgroundColor(Color.parseColor(procedures.get(position).getColor()));
        holder.image.setImageResource((int)procedures.get(position).getImage());
        holder.titleTxt.setText(procedures.get(position).getName());
        holder.infoTxt.setText(procedures.get(position).getDescription());
        holder.durationTxt.setText(procedures.get(position).getDuration() + " хвилин");
        holder.costTxt.setText(procedures.get(position).getCost() + " грн");
    }
    private String getColor(){
        String[] colors = {
                "","",""
        };
       // int random
        return "";
    }

    @Override
    public int getItemCount() {
        return procedures.size();
    }

    public static final class ProcedureViewHolder extends  RecyclerView.ViewHolder{

        LinearLayout courseBg;
        ImageView image;
        TextView titleTxt,infoTxt,durationTxt,costTxt;


        public ProcedureViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBg = itemView.findViewById(R.id.CardLayout);
            image = itemView.findViewById(R.id.CardAvatar);
            titleTxt = itemView.findViewById(R.id.cardTitle);
            infoTxt = itemView.findViewById(R.id.cardInfo);
            durationTxt = itemView.findViewById(R.id.cardDuration);
            costTxt = itemView.findViewById(R.id.cardCost);

        }
    }
}
