package net.gshp.apimessages.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by gnu on 22/02/17.
 */

public class AppDb extends SQLiteOpenHelper {


    public AppDb(Context context) {
        super(context, "message.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        switch (oldVersion) {
            case 1:

            default:
                break;
        }

    }
}
