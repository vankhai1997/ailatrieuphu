package firstproject.t3h.com.ailatrieuphu;

import android.app.Application;

/**
 * Created by LE VAN KHAI on 3/12/2018.
 */

public class MyApplication extends Application {
    private PostScore postScore;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void postScore(int score){
        if  ( postScore == null ) {
            return;
        }
        postScore.postscore(score);
    }

    public void setPostScore(PostScore postScore) {
        this.postScore = postScore;
    }

    public interface PostScore {
        void postscore(int score);
    }
}
