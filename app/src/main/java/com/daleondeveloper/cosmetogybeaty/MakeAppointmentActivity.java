package com.daleondeveloper.cosmetogybeaty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.daleondeveloper.cosmetogybeaty.DB.CosmetologyDataBase;
import com.daleondeveloper.cosmetogybeaty.DB.DataBaseRxThread;
import com.daleondeveloper.cosmetogybeaty.adapter.ProcedureAdapter;

import org.w3c.dom.Text;

public class MakeAppointmentActivity extends AppCompatActivity {

    private DataBaseRxThread dataBaseRxThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_appointment);
        dataBaseRxThread = new DataBaseRxThread(CosmetologyDataBase.getInstance(this));
        Intent intent = getIntent();
        String procedure_name = intent.getStringExtra(ProcedureAdapter.INTENT_PROCEDURE);
        TextView textView = (TextView)findViewById(R.id.duration_make_appointment);
        TextView textView1 = (TextView)findViewById(R.id.cost_make_appointment);
        System.out.println(textView.getText() + " :::::: " + textView1.getText());

        dataBaseRxThread.setSpinnerMakeAppointment(this,R.id.spinner_make_appointment);
        setCostAndDuration(procedure_name);
        Spinner spinner = findViewById(R.id.spinner_make_appointment);
        final Activity activity = this;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView)view;
                setCostAndDuration((String)textView.getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setCostAndDuration(String name){
        dataBaseRxThread.setMakeAppointmentCostAndDuration((MakeAppointmentActivity)this,name);

    }
    public void setOnTextView(int cost, int duration){
        TextView costTextView = (TextView)findViewById(R.id.cost_make_appointment);
        TextView durationTextView = (TextView)findViewById(R.id.duration_make_appointment);
        costTextView.setText("вартість : " + cost + " грн");
        durationTextView.setText("тривалість : " +duration + " хв");
    }

}