package com.daleondeveloper.cosmetogybeaty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.daleondeveloper.cosmetogybeaty.DB.CosmetologyDataBase;
import com.daleondeveloper.cosmetogybeaty.DB.DataBaseRxThread;
import com.daleondeveloper.cosmetogybeaty.adapter.ProcedureAdapter;

import org.w3c.dom.Text;

public class MakeAppointmentActivity extends AppCompatActivity {

    private DataBaseRxThread dataBaseRxThread;
    private String sendMessage;
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
        sendMessage = "Доброго дня, хочу записатися на " + name;


    }
    public void setOnTextView(int cost, int duration){
        TextView costTextView = (TextView)findViewById(R.id.cost_make_appointment);
        TextView durationTextView = (TextView)findViewById(R.id.duration_make_appointment);
        costTextView.setText("вартість : " + cost + " грн");
        durationTextView.setText("тривалість : " +duration + " хв");
    }

    public void sendMessageViber(View view){
        Toast.makeText(this, "Viber button pressed", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("viber://chat?number=380978006658"));
//        intent.setPackage("com.viber.voip");
//        intent.setType("text/plain");
        startActivity(intent);
    }
public void sendMessageTelegram(View view){
        Toast.makeText(this, "Viber button pressed", Toast.LENGTH_SHORT).show();

    Intent i = new Intent(Intent.ACTION_VIEW);
    i.setData(Uri.parse("http://telegram.me/difficult_username"));
    final String appName = "org.telegram.messenger";
    i.setPackage(appName);
    this.startActivity(i);
    }
    public void sendMessageInstagram(View view){
        Toast.makeText(this, "Viber button pressed", Toast.LENGTH_SHORT).show();

        Uri uri = Uri.parse("http://instagram.com/_u/place_of_beauty_cosmetology");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/xxx")));
        }
    }


}