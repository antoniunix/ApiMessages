package net.gshp.messagesandfiles.sqliteTables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.gshp.messagesandfiles.dto.DtoDataProperties;

public class AppDB extends SQLiteOpenHelper {


    public AppDB(Context context, DtoDataProperties dto) {

        super(context, dto.getDataBasePath(), null, dto.getDataBaseVersion());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tables.TABLE_FILES_HEAD);
        db.execSQL(Tables.TABLE_FILES);
        db.execSQL(Tables.TABLE_MESSAGES);
        db.execSQL(Tables.TABLE_MESSAGE_FILE_VIEWED);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {

            case 1:
                break;

            default:
                break;
        }
    }

}