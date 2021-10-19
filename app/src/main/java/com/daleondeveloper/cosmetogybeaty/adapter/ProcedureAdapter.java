package com.daleondeveloper.cosmetogybeaty.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
        Resources res = context.getResources();
        int id = res.getIdentifier(procedures.get(position).getImage(), "drawable", context.getPackageName());
        holder.image.setImageResource(id);
        holder.titleTxt.setText(procedures.get(position).getName());
        holder.infoTxt.setText(procedures.get(position).getShortDescription());
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
        ViewGroup.LayoutParams moreInfoLP = holder.moreInfo.getLayoutParams();
        moreInfoLP.height = 0;
        ViewGroup.LayoutParams imageLP = holder.image.getLayoutParams();
        imageLP.height = 0;
        holder.procedureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float factor = holder.itemView.getContext().getResources().getDisplayMetrics().density;
                ViewGroup.LayoutParams moreInfoLP = holder.moreInfo.getLayoutParams();
                ViewGroup.LayoutParams imageLP = holder.image.getLayoutParams();
                Toast.makeText(context,"Card view pressed", Toast.LENGTH_LONG);
                if(moreInfoLP.height == 0){
                    moreInfoLP.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    imageLP.height = (int)(208 * factor);
                    holder.moreInfo.setLayoutParams(moreInfoLP);
                }else {
                    moreInfoLP.height = 0;
                    imageLP.height = 0;
                    holder.moreInfo.setLayoutParams(moreInfoLP);

                }
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
        LinearLayout moreInfo;
        CardView procedureCard;
        ImageView image;
        TextView titleTxt,infoTxt,durationTxt,costTxt;
        Button buttonMakeAppointment;
        Button buttonAboutProcedure;



        public ProcedureViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBg = itemView.findViewById(R.id.CardLayout);
            moreInfo = itemView.findViewById(R.id.layoutMoreInfo);
            procedureCard = itemView.findViewById(R.id.procedureCard);
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
