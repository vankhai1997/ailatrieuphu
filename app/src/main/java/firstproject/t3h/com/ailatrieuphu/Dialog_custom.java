package firstproject.t3h.com.ailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Created by LE VAN KHAI on 3/6/2018.
 */

public class Dialog_custom extends Dialog implements View.OnClickListener {


    Context context = getContext();
    private int score;
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
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_finish:
                ((MyApplication)getContext().getApplicationContext()).postScore(score);
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
