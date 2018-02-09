package net.gshp.messagesandfiles.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import net.gshp.messagesandfiles.dto.DtoDataProperties;
import net.gshp.messagesandfiles.dto.DtoFilesHead;
import net.gshp.messagesandfiles.sqliteTables.AppDB;

import java.util.List;

/**
 * Created by gnu on 1/02/18.
 */

public class DaoFilesHead {
    protected AppDB helper;
    protected SQLiteDatabase db;
    protected Cursor cursor;

    private final static String TABLE_NAME = "files_head";
    private final static String PK_FIELD = "id";

    private final static String ID = "id";
    private final static String DESCRIPTION = "description";
    private final static String START_DATE = "start_date";
    private final static String END_DATE = "end_date";

    public DaoFilesHead(Context context, DtoDataProperties dto) {
        helper = new AppDB(context, dto);
    }

    /**
     * Insert
     */
    public int insert(List<DtoFilesHead> obj) {
        db = helper.getWritableDatabase();
        int resp = 0;
        try {
            String qry = "INSERT INTO " +
                    TABLE_NAME + " (" + ID + "," + DESCRIPTION + "," + START_DATE + "," + END_DATE + ") VALUES(?,?,?,?)";

            SQLiteStatement insStmnt = db.compileStatement(qry);
            db.beginTransaction();
            for (DtoFilesHead dto : obj) {
                try {
                    insStmnt.bindLong(1, dto.getId());
                } catch (Exception e) {
                    insStmnt.bindNull(1);
                }
                try {
                    insStmnt.bindString(2, dto.getDescription());
                } catch (Exception e) {
                    insStmnt.bindNull(2);
                }
                try {
                    insStmnt.bindString(3, dto.getStartDate());
                } catch (Exception e) {
                    insStmnt.bindNull(3);
                }
                try {
                    insStmnt.bindString(4, dto.getEndDate());
                } catch (Exception e) {
                    insStmnt.bindNull(4);
                }
                insStmnt.executeInsert();
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            db.close();
        }
        return resp;
    }
}
