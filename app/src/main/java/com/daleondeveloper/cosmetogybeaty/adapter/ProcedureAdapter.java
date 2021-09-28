package com.daleondeveloper.cosmetogybeaty.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daleondeveloper.cosmetogybeaty.DB.Entity.Procedure;
import com.daleondeveloper.cosmetogybeaty.MakeAppointmentActivity;
import com.daleondeveloper.cosmetogybeaty.ProcedureInfoActivity;
import com.daleondeveloper.cosmetogybeaty.R;

import java.util.List;

public class ProcedureAdapter extends RecyclerView.Adapter<ProcedureAdapter.ProcedureViewHolder> {

    public static final String INTENT_PROCEDURE = "procedure_name";

    private Context context;
    private List<Procedure> procedures;

    public ProcedureAdapter(Context context, List<Procedure> procedures) {
        this.context = context;
        this.procedures = procedures;
    }

    @NonNull
    @Override
    public ProcedureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItem = LayoutInflater.from(context).inflate(R.layout.element_card_view_procedures,parent,false);
        return  new ProcedureViewHolder(courseItem);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProcedureViewHolder holder, final int position) {

      //  holder.courseBg.setBackgroundColor(Color.parseColor(procedures.get(position).getColor()));
        holder.image.setImageResource((int)procedures.get(position).getImage());
        holder.titleTxt.setText(procedures.get(position).getName());
        holder.infoTxt.setText(procedures.get(position).getDescription());
        holder.durationTxt.setText(procedures.get(position).getDuration() + " хвилин");
        holder.costTxt.setText(procedures.get(position).getCost() + " грн");
        holder.buttonMakeAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MakeAppointmentActivity.class);
                intent.putExtra(INTENT_PROCEDURE,procedures.get(position).getName());
                context.startActivity(intent);
            }
        });
        holder.buttonAboutProcedure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProcedureInfoActivity.class);
                intent.putExtra(INTENT_PROCEDURE,procedures.get(position).getName());
                context.startActivity(intent);
            }
        });
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
        Button buttonMakeAppointment;
        Button buttonAboutProcedure;


        public ProcedureViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBg = itemView.findViewById(R.id.CardLayout);
            image = itemView.findViewById(R.id.CardAvatar);
            titleTxt = itemView.findViewById(R.id.cardTitle);
            infoTxt = itemView.findViewById(R.id.cardInfo);
            durationTxt = itemView.findViewById(R.id.cardDuration);
            costTxt = itemView.findViewById(R.id.cardCost);
            buttonMakeAppointment = itemView.findViewById(R.id.cardButtonMakeAppointment);
            buttonAboutProcedure = itemView.findViewById(R.id.cardButtonAboutProcedure);
        }
    }
}
