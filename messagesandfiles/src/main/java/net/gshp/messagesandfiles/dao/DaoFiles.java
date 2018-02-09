package net.gshp.messagesandfiles.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import net.gshp.messagesandfiles.R;
import net.gshp.messagesandfiles.dto.DtoDataProperties;
import net.gshp.messagesandfiles.dto.DtoFiles;
import net.gshp.messagesandfiles.dto.DtoMessageAndFiles;
import net.gshp.messagesandfiles.sqliteTables.AppDB;
import net.gshp.messagesandfiles.util.ReadPropertiesAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnu on 1/02/18.
 */

public class DaoFiles {
    protected AppDB helper;
    protected SQLiteDatabase db;
    protected Cursor cursor;

    private final static String TABLE_NAME = "files";
    private final static String PK_FIELD = "id";

    private final static String ID = "id";
    private final static String ID_MESSAGE_FILES_HEAD = "id_message_files_head";
    private final static String ID_ITEM_RELATION = "id_item_relation";
    private final static String TITLE = "title";
    private final static String DESCRIPTION = "description";
    private final static String EXTENTION = "extention";
    private final static String MD5 = "md5";
    private final static String URL = "url";
    private final static String LAST_UPDATE = "last_update";

    private Context context;

    public DaoFiles(Context context) {
        helper = new AppDB(context, new ReadPropertiesAssets().readPropertiesFile(context));
        this.context = context;
    }

    /**
     * Insert
     */
    public int insert(List<DtoFiles> obj) {
        db = helper.getWritableDatabase();
        int resp = 0;
        try {
            String qry = "INSERT INTO " +
                    TABLE_NAME + " (" + ID + "," + ID_MESSAGE_FILES_HEAD + "," + ID_ITEM_RELATION
                    + "," + TITLE + "," + DESCRIPTION + "," + EXTENTION + "," + MD5 + "," + URL + "," + LAST_UPDATE + ") " +
                    "VALUES(?,?,?,?,?,?,?,?,?)";

            SQLiteStatement insStmnt = db.compileStatement(qry);
            db.beginTransaction();
            for (DtoFiles dto : obj) {
                try {
                    insStmnt.bindLong(1, dto.getId());
                } catch (Exception e) {
                    insStmnt.bindNull(1);
                }
                try {
                    insStmnt.bindLong(2, dto.getIdMessageFilesHead());
                } catch (Exception e) {
                    insStmnt.bindNull(2);
                }
                try {
                    insStmnt.bindLong(3, dto.getIdItemRelation());
                } catch (Exception e) {
                    insStmnt.bindNull(3);
                }
                try {
                    insStmnt.bindString(4, dto.getTitle());
                } catch (Exception e) {
                    insStmnt.bindNull(4);
                }
                try {
                    insStmnt.bindString(5, dto.getDescription());
                } catch (Exception e) {
                    insStmnt.bindNull(5);
                }
                try {
                    insStmnt.bindString(6, dto.getExtention());
                } catch (Exception e) {
                    insStmnt.bindNull(6);
                }
                try {
                    insStmnt.bindString(7, dto.getMd5());
                } catch (Exception e) {
                    insStmnt.bindNull(7);
                }
                try {
                    insStmnt.bindString(8, dto.getUrl());
                } catch (Exception e) {
                    insStmnt.bindNull(8);
                }
                try {
                    insStmnt.bindLong(9, dto.getLastUpdate());
                } catch (Exception e) {
                    insStmnt.bindNull(9);
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

    public List<DtoMessageAndFiles> select(List<DtoMessageAndFiles> obj) {
        db = helper.getReadableDatabase();

        String qry = "SELECT\n" +
                "files.id_item_relation,\n" +
                "files.title,\n" +
                "files.description,\n" +
                "files.extention,\n" +
                "files.md5,\n" +
                "files.url\n" +
                "FROM\n" +
                "files_head\n" +
                "INNER JOIN files ON files_head.id = files.id_message_files_head";
        cursor = db.rawQuery(qry, null);
        DtoMessageAndFiles catalog;
        if (cursor.moveToFirst()) {
            int columnIdItemRelation = cursor.getColumnIndexOrThrow(ID_ITEM_RELATION);
            int columnTitle = cursor.getColumnIndexOrThrow(TITLE);
            int columnDescription = cursor.getColumnIndexOrThrow(DESCRIPTION);
            int columnExtention = cursor.getColumnIndexOrThrow(EXTENTION);
            int columnMD5 = cursor.getColumnIndexOrThrow(MD5);
            int columnUrl = cursor.getColumnIndexOrThrow(URL);

            do {
                catalog = new DtoMessageAndFiles();
                catalog.setIdItemRelation(cursor.getLong(columnIdItemRelation));
                catalog.setTitle(cursor.getString(columnTitle));
                catalog.setDescription(cursor.getString(columnDescription));
                catalog.setExtention(cursor.getString(columnExtention));
                catalog.setEndDate(cursor.getString(columnMD5));
                catalog.setUrl(cursor.getString(columnUrl));
                catalog.setTypeModule(context.getResources().getInteger(R.integer.type_module_file));
                obj.add(catalog);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return obj;
    }
}
