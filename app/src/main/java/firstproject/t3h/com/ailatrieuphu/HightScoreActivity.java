package firstproject.t3h.com.ailatrieuphu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import firstproject.t3h.com.ailatrieuphu.database.DatabaseManager;

public class HightScoreActivity extends AppCompatActivity {
    DatabaseManager databaseManager;
    private TextView tvName;
    private TextView tvLevel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hight_score);
        databaseManager= new DatabaseManager(this);

        tvLevel = findViewById(R.id.tv_level);
        tvName = findViewById(R.id.tv_hoten);
        init();
    }

    private void init() {
        databaseManager.getHightScore();
        tvLevel.setText(""+databaseManager.getLevel());
        tvName.setText(""+databaseManager.getName());

    }
}
