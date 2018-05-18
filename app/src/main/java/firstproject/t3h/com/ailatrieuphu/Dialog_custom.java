package firstproject.t3h.com.ailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;

/**
 * Created by LE VAN KHAI on 3/6/2018.
 */

public class Dialog_custom extends Dialog implements View.OnClickListener {
    private EditText edtUsername;
private DatabaseManager databaseManager;
    Context context = getContext();
    public static int level=0;
    public Dialog_custom(@NonNull Context context) {
        super(context);
        inisView();
    }

    private void inisView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom);
        getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);
        findViewById(R.id.btn_finish).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        edtUsername = findViewById(R.id.edt_username);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_finish:
//                ((MyApplication)getContext().getApplicationContext()).postScore(score);
               String name= edtUsername.getText().toString();
                databaseManager = new DatabaseManager(this.getContext());
                HighScore highScore
                         = new HighScore();
                highScore.setName(name);



                    highScore.setLevelPass(level);

                    databaseManager.insertHighScore(highScore);

                dismiss();
                break;
            case  R.id.btn_cancel:
                dismiss();
                break;
                default:
                    break;

        }
    }
}
