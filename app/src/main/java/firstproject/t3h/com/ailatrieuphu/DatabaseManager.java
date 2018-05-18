package firstproject.t3h.com.ailatrieuphu;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by LE VAN KHAI on 3/3/2018.
 */

public class DatabaseManager {

    private static final String DB_NAME = "trieuphu_games";
    private final String pathDb;
    public static Question question;
    public static String answer;
    public static int number = 1;
    Cursor c;

    public static boolean ckeckAnswer;
    private SQLiteDatabase sqliteManager;
    private Context context;

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        DatabaseManager.number = number;
    }

    public static boolean isCkeckAnswer() {
        return ckeckAnswer;
    }

    public static void setCkeckAnswer(boolean ckeckAnswer) {
        DatabaseManager.ckeckAnswer = ckeckAnswer;
    }


    public DatabaseManager(Context context) {
        this.context = context;
        pathDb = Environment.getDataDirectory()
                + File.separator + "data"
                + File.separator + context.getPackageName()
                + File.separator + "database"
                + File.separator + DB_NAME;

    }

    private void coppyDB() {
        String paht
                = Environment.getDataDirectory()
                //duong dan external cua toan bo app
                + File.separator + "data"
                + File.separator + context.getPackageName()
                //duong dan external cua app hien tai
                + File.separator + "database";
        new File(paht).mkdir();
        File file = new File(pathDb);
        if (file.exists()) {
            return;
        }
        //copy
        AssetManager manager = context.getAssets();
        try {
            InputStream in = manager.open(DB_NAME);
            OutputStream out = new FileOutputStream(file);
            byte[] b = new byte[1024];
            int le = in.read(b);
            while (le > -1) {
                out.write(b, 0, le);
                le = in.read(b);
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openDB() {
        coppyDB();
        if (sqliteManager == null ||
                !sqliteManager.isOpen()) {
            sqliteManager = SQLiteDatabase
                    .openDatabase(pathDb, null,
                            SQLiteDatabase.OPEN_READWRITE);
        }
    }

    public void closeDB() {
        if (sqliteManager != null &&
                sqliteManager.isOpen()) {
//            sqliteManager.close();
        }
    }

    public List<Question> queryFitTeen() {
        List<Question> questions = new ArrayList<>();
        openDB();
        //cau len sql

//        if (isCkeckAnswer() == true) {
//           number++;
//            Log.d("aaaaaaaaaaaaaaaa", "" + getNumber());
//        }
        if (number == 1) {

            c = sqliteManager.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =1 limit 1",
                    null);
            ckeckAnswer = false;
        }
        if (number == 2) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =2 limit 1",
                            null);
            ckeckAnswer = false;
        }
        if (number == 3) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =3 limit 1",
                            null);
            ckeckAnswer = false;
        }
        if (number == 4) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =4 limit 1",
                            null);
            ckeckAnswer = false;
        }
        if (number == 5) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =5 limit 1",
                            null);
            ckeckAnswer = false;
        }
        if (number == 6) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =6 limit 1",
                            null);
            ckeckAnswer = false;
        }
        if (number == 7) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =7 limit 1",
                            null);
            ckeckAnswer = false;
        }
        if (number == 8) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =8 limit 1",
                            null);
            ckeckAnswer = false;
        }
        if (number == 9) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =9 limit 1",
                            null);
            ckeckAnswer = false;
        }
        if (number == 10) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =10 limit 1",
                            null);
            ckeckAnswer = false;
        }
        if (number == 11) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =11 limit 1",
                            null);
            ckeckAnswer = false;
        }
        if (number == 12) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =12 limit 1",
                            null);
            ckeckAnswer = false;
        }

        if (number == 13) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =13 limit 1",
                            null);
            ckeckAnswer = false;
        }

        if (number == 14) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =14 limit 1",
                            null);
            ckeckAnswer = false;
        }

        if (number == 15) {
            c =
                    sqliteManager.rawQuery(
                            "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =15 limit 1",
                            null);
            ckeckAnswer = false;
        }


        while (true) {
            if (c != null) {
                int indexId = c.getColumnIndex("id");
                int inAsk = c.getColumnIndex("ask");
                int inRa = c.getColumnIndex("ra");

                int inRb = c.getColumnIndex("rb");
                int inRc = c.getColumnIndex("rc");
                int inRd = c.getColumnIndex("rd");
                int inLevel = c.getColumnIndex("level");
                c.moveToFirst();

                int id = c.getInt(indexId);
                String ask = c.getString(inAsk);
                String ra = c.getString(inRa);
                answer = ra;
                String rb = c.getString(inRb);
                String rc = c.getString(inRc);
                String rd = c.getString(inRd);
                int level = c.getInt(inLevel);

                List<String> rs = new ArrayList<>();
                rs.add(ra);
                rs.add(rb);
                rs.add(rc);
                rs.add(rd);
                Collections.shuffle(rs);
                question = new Question();
                question.setLevel(level);
                question.setId(id);
                question.setAsk(ask);
                question.setRa(rs.get(0));
                question.setRb(rs.get(1));
                question.setRc(rs.get(2));
                question.setRd(rs.get(3));
                questions.add(question);
//                Toast.makeText(context, ""+level, Toast.LENGTH_SHORT).show();

                c.moveToNext();

                c.close();
            }
            closeDB();
            Log.d("sss", "queryFitTeen: "+questions.size());
            return questions;
        }
    }
}
