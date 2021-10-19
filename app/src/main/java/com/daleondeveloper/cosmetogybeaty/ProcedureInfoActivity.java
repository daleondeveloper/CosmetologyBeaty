package com.daleondeveloper.cosmetogybeaty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.daleondeveloper.cosmetogybeaty.DB.CosmetologyDataBase;
import com.daleondeveloper.cosmetogybeaty.DB.DataBaseRxThread;
import com.daleondeveloper.cosmetogybeaty.DB.Entity.Procedure;
import com.daleondeveloper.cosmetogybeaty.adapter.ProcedureAdapter;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class ProcedureInfoActivity extends YouTubeBaseActivity {

    String api_key = "AIzaSyDqKPUcYaHxX1i7Tou4_upIXTlJIH8T-LM";
    private TextView title;
    private TextView cost;
    private TextView duration;
    private TextView text;
    private ImageView image;
    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedure_info);

        Intent intent = getIntent();
        String procedure_name = intent.getStringExtra(ProcedureAdapter.INTENT_PROCEDURE);

        title = (TextView)findViewById(R.id.info_procedure_name);
        cost = (TextView)findViewById(R.id.info_procedure_cost);
        duration = (TextView)findViewById(R.id.info_procedure_duration);
        text = (TextView)findViewById(R.id.info_procedure_text);
        image = (ImageView)findViewById(R.id.info_procedure_img);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.info_procedure_youtube_video_view);

        DataBaseRxThread dataBaseRxThread = new DataBaseRxThread(CosmetologyDataBase.getInstance(this));
        dataBaseRxThread.setInfoActivityDate(this,procedure_name);

    }

    public void updateActivityDate(final Procedure procedure){
        title.setText(procedure.getName());
        cost.setText("вартість : " + procedure.getCost() + " грн");
        duration.setText("тривалість : " + procedure.getDuration() + " хв");
        text.setText(procedure.getDescription());
        Resources res = getResources();
        int id = res.getIdentifier(procedure.getImage(), "drawable", this.getPackageName());
        image.setImageResource(id);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(procedure.getYoutubeId(), 0);
                youTubePlayer.pause();
            }

        });
    }
    public void sendMessageViber(View view){
        Toast.makeText(this, "Viber button pressed", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("viber://chat?number=380688661006"));
//        intent.setPackage("com.viber.voip");
//        intent.setType("text/plain");
        startActivity(intent);
    }
    public void sendMessageTelegram(View view){
        Toast.makeText(this, "Viber button pressed", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://telegram.me/daleon96"));
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