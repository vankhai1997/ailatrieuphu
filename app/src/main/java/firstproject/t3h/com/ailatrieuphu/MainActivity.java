package firstproject.t3h.com.ailatrieuphu;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyApplication.PostScore {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button btnPlay;
    public static boolean isPlay = true;
    public static boolean btnStart;
    public static boolean btnStop = true;
    public static boolean btnCall;
    public static boolean btnPercent;
    public static boolean btnHelp;
    private MediaPlayer musicMain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisView();
        btnCall = true;
        btnPercent = true;
        btnStart = true;
        btnHelp = true;
        Log.d(TAG, "onCreate: "+Activity_PlayGame.isIsShowDialog());
        if (Activity_PlayGame.isIsShowDialog()==true){
            Dialog_custom dialog_custom = new Dialog_custom(MainActivity.this);
            dialog_custom.setCancelable(false);
            dialog_custom.setCanceledOnTouchOutside(false);
            dialog_custom.show();
        }

        ((MyApplication) getApplicationContext()).setPostScore(this);
    }

    private void inisView() {
        btnPlay = findViewById(R.id.btnplay);
        btnPlay.setOnClickListener(this);
        musicMain = MediaPlayer.create(this, R.raw.bgmusic);
        musicMain.start();
    }

    @Override
    public void onClick(View view) {
        Intent itPlay = new Intent(MainActivity.this, Activity_Level.class);
        startActivity(itPlay);
        musicMain.release();
    }

    @Override
    public void postscore(int score) {
        Log.d(TAG, "postscore score: " + score);
    }

}
